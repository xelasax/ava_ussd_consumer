package com.xdatechnologies.avaconsumer.service;

import com.xdatechnologies.avaconsumer.config.SMSConfiguration;
import com.xdatechnologies.avaconsumer.models.SMSInternalCallback;
import com.xdatechnologies.ussd.models.SMSTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class SMSProcessor {

    private final SMSConfiguration smsConfiguration;

    @Value("${ava.ussd.url}")
    private String mainUSSDAppURL;

    @Autowired
    public SMSProcessor(SMSConfiguration smsConfiguration) {
        this.smsConfiguration = smsConfiguration;
    }

    public void processSMS(SMSTemplate receivedData) {
        log.info("SMS TO BE SENT : " + receivedData);
        Mono.just(receivedData)
                .flatMap(messageDetails -> {
                            log.info("SMS URL =>" + messageDetails);
                            return WebClient.create(smsConfiguration.getBaseUrl())
                                    .get()
                                    .uri(uriBuilder -> uriBuilder
                                            .path("bulksms/")
                                            .queryParam("username", smsConfiguration.getUsername())
                                            .queryParam("password", smsConfiguration.getPassword())
                                            .queryParam("type", smsConfiguration.getType())
                                            .queryParam("dlr", smsConfiguration.getDlr())
                                            .queryParam("source", smsConfiguration.getSource())
                                            .queryParam("destination", messageDetails.getMsisdn())
                                            .queryParam("message", messageDetails.getMessageContent())
                                            .build()
                                    )
                                    .retrieve()
                                    .bodyToMono(String.class)
                                    .log()
                                    .onErrorReturn("50000|UNABLE TO FORWARD SMS TO GATEWAY |GH500000000");
                        }
                ).flatMap(returnedResponse -> WebClient.create(mainUSSDAppURL)
                .post()
                .uri("/sms")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(new SMSInternalCallback(returnedResponse, receivedData.getReferenceID())), SMSInternalCallback.class)
                .retrieve()
                .bodyToMono(Void.class)
        ).onErrorContinue((throwable, o) -> log.error(throwable.getMessage()))
         .subscribe((nothing) -> log.info("MESSAGE SENT"));
    }
}

