package com.xdatechnologies.avaconsumer.service;

import com.xdatechnologies.avaconsumer.config.AMQPPropertiesConfig;
import com.xdatechnologies.avaconsumer.config.PaymentPropertiesConfig;
import com.xdatechnologies.avaconsumer.models.PaymentRequest;
import com.xdatechnologies.avaconsumer.models.PaymentResponse;
import com.xdatechnologies.ussd.models.PAYMENTTemplate;
import com.xdatechnologies.ussd.models.SMSTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

@Service
@Slf4j
public class PaymentProcessor {

    private final PaymentPropertiesConfig paymentPropertiesConfig;
    private final RabbitTemplate rabbitTemplate;
    private final AMQPPropertiesConfig amqpPropertiesConfig;

    @Value("${MTN}")
    private Set<String> MTN;

    @Value("${VODAFONE}")
    private Set<String> VODAFONE;

    @Value("${AIRTELTIGO}")
    private Set<String> AIRTELTIGO;

    @Value("${testMSISDN}")
    private String testMSISDN;

    @Value("${payment.client.percentage}")
    private BigDecimal percentage;

    @Autowired
    public PaymentProcessor(PaymentPropertiesConfig paymentPropertiesConfig, RabbitTemplate rabbitTemplate, AMQPPropertiesConfig amqpPropertiesConfig) {
        this.paymentPropertiesConfig = paymentPropertiesConfig;
        this.rabbitTemplate = rabbitTemplate;
        this.amqpPropertiesConfig = amqpPropertiesConfig;
    }

    public void processPayment(PAYMENTTemplate paymentTemplate) {
        log.info(paymentTemplate.toString());

        Mono.just(paymentTemplate)
                .map(details -> {
                    BigDecimal actualAmount = new BigDecimal(paymentTemplate.getAmount());
                    BigDecimal percentageAmount = actualAmount.multiply(percentage);
                    BigDecimal chargeAmount = actualAmount.add(percentageAmount);
                    log.info("Amount To Be Debited " + chargeAmount);
                    return new PaymentRequest(
                        paymentPropertiesConfig.merchantId,
                        paymentPropertiesConfig.productId,
                        details.getRefNo(),
                        formatMSISDN(details.getMsisdn(), details.getRequestMSISDN(), paymentTemplate.getRefNo()),
                        chargeAmount.setScale(2, RoundingMode.CEILING).toPlainString(),
                        getNetWork(details.getMsisdn()),
                        details.getNarration(),
                        paymentPropertiesConfig.apiKey);
                })
                .flatMap(payload -> {
                    log.info("Payload to post to debit endpoint " + payload.toString());
                    return paymentPropertiesConfig.BaseClient()
                            .post()
                            .uri("/uniwallet/debit/customer")
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(Mono.just(payload), PaymentRequest.class)
                            .retrieve()
                            .bodyToMono(PaymentResponse.class)
                            .log("Returned Response");
                })
//                .onErrorContinue((throwable, o) -> log.error(throwable.getMessage()))
                .doOnError(throwable -> log.error("An Error Occurred", throwable.getCause()))
                .subscribe((paymentResponse -> log.info("Payment Response " + paymentResponse.toString())), throwable -> log.error("An Error Occurred : " + throwable.getLocalizedMessage()));

    }

    public String formatMSISDN(String msisdn, String originMsisdn, String referenceNo) {
        if (msisdn.length() == 12 && msisdn.startsWith("233")) {
            return testMSISDN.equals("233240974010") ? testMSISDN : msisdn;
        } else if (msisdn.length() == 10 && msisdn.startsWith("0")) {
            return testMSISDN.equals("233240974010") ? testMSISDN : "233" + msisdn.substring(1);
        }
        log.error("INVALID MSISDN ==> " + msisdn);
        rabbitTemplate.convertAndSend(
                amqpPropertiesConfig.getExchange(),
                amqpPropertiesConfig.getSmsRoutingKey(),
                new SMSTemplate(originMsisdn, "Payment failed due to invalid payment wallet number (" + msisdn + ")", referenceNo)
        );
        throw new RuntimeException("Invalid phone number");
    }

    public String getNetWork(String msisdn) {
        log.info("SMS TO GET NETWORK " + msisdn);

        final String firstFiveChars = msisdn.substring(0, 5);
        if (MTN.contains(firstFiveChars)) {
            return "MTN";
        } else if (VODAFONE.contains(firstFiveChars)) {
            return "VODAFONE";
        } else if (AIRTELTIGO.contains(firstFiveChars)) {
            return "ARTLTIGO";
        }
        throw new RuntimeException("INVALID NETWORK PREFIX");
    }
}
