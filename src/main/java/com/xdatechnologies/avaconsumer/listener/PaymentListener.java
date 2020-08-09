package com.xdatechnologies.avaconsumer.listener;

import com.xdatechnologies.avaconsumer.service.PaymentProcessor;
import com.xdatechnologies.ussd.models.PAYMENTTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentListener {

    private final PaymentProcessor paymentProcessor;

    @Autowired
    public PaymentListener(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    @RabbitListener(queues = "alpha-virtual-academy-payment-queue")
    public void paymentListenerA(PAYMENTTemplate paymentRequest){
        paymentProcessor.processPayment(paymentRequest);
        log.info("PAYMENT WORKER A");
    }

    @RabbitListener(queues = "alpha-virtual-academy-payment-queue")
    public void paymentListenerB(PAYMENTTemplate paymentRequest){
        paymentProcessor.processPayment(paymentRequest);
        log.info("PAYMENT WORKER B");
    }

    @RabbitListener(queues = "alpha-virtual-academy-payment-queue")
    public void paymentListenerC(PAYMENTTemplate paymentRequest){
        paymentProcessor.processPayment(paymentRequest);
        log.info("PAYMENT WORKER C");
    }

    @RabbitListener(queues = "alpha-virtual-academy-payment-queue")
    public void paymentListenerD(PAYMENTTemplate paymentRequest){
        paymentProcessor.processPayment(paymentRequest);
        log.info("PAYMENT WORKER D");
    }

    @RabbitListener(queues = "alpha-virtual-academy-payment-queue")
    public void paymentListenerE(PAYMENTTemplate paymentRequest){
        paymentProcessor.processPayment(paymentRequest);
        log.info("PAYMENT WORKER E");
    }

    @RabbitListener(queues = "alpha-virtual-academy-payment-queue")
    public void paymentListenerF(PAYMENTTemplate paymentRequest){
        paymentProcessor.processPayment(paymentRequest);
        log.info("PAYMENT WORKER F");
    }

    @RabbitListener(queues = "alpha-virtual-academy-payment-queue")
    public void paymentListenerG(PAYMENTTemplate paymentRequest){
        paymentProcessor.processPayment(paymentRequest);
        log.info("PAYMENT WORKER G");
    }

    @RabbitListener(queues = "alpha-virtual-academy-payment-queue")
    public void paymentListenerH(PAYMENTTemplate paymentRequest){
        paymentProcessor.processPayment(paymentRequest);
        log.info("PAYMENT WORKER H");
    }

    @RabbitListener(queues = "alpha-virtual-academy-payment-queue")
    public void paymentListenerI(PAYMENTTemplate paymentRequest){
        paymentProcessor.processPayment(paymentRequest);
        log.info("PAYMENT WORKER I");
    }

    @RabbitListener(queues = "alpha-virtual-academy-payment-queue")
    public void paymentListenerJ(PAYMENTTemplate paymentRequest){
        paymentProcessor.processPayment(paymentRequest);
        log.info("PAYMENT WORKER J");
    }

}
