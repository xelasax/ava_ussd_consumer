package com.xdatechnologies.avaconsumer.listener;

import com.xdatechnologies.avaconsumer.service.SMSProcessor;
import com.xdatechnologies.ussd.models.SMSTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SMSListener {

    private final SMSProcessor smsProcessor;

    @Autowired
    public SMSListener(SMSProcessor smsProcessor) {
        this.smsProcessor = smsProcessor;
    }

    @RabbitListener(queues = "alpha-virtual-academy-sms-queue")
    public void SMSListenerA(SMSTemplate smsTemplate) {
        smsProcessor.processSMS(smsTemplate);
        log.info("SMS WORKER A");
    }
    @RabbitListener(queues = "alpha-virtual-academy-sms-queue")
    public void SMSListenerB(SMSTemplate smsTemplate) {
        smsProcessor.processSMS(smsTemplate);
        log.info("SMS WORKER B");
    }
    @RabbitListener(queues = "alpha-virtual-academy-sms-queue")
    public void SMSListenerC(SMSTemplate smsTemplate) {
        smsProcessor.processSMS(smsTemplate);
        log.info("SMS WORKER C");
    }
    @RabbitListener(queues = "alpha-virtual-academy-sms-queue")
    public void SMSListenerD(SMSTemplate smsTemplate) {
        smsProcessor.processSMS(smsTemplate);
        log.info("SMS WORKER D");
    }
    @RabbitListener(queues = "alpha-virtual-academy-sms-queue")
    public void SMSListenerE(SMSTemplate smsTemplate) {
        smsProcessor.processSMS(smsTemplate);
        log.info("SMS WORKER E");
    }
    @RabbitListener(queues = "alpha-virtual-academy-sms-queue")
    public void SMSListenerF(SMSTemplate smsTemplate) {
        smsProcessor.processSMS(smsTemplate);
        log.info("SMS WORKER F");
    }
    @RabbitListener(queues = "alpha-virtual-academy-sms-queue")
    public void SMSListenerG(SMSTemplate smsTemplate) {
        smsProcessor.processSMS(smsTemplate);
        log.info("SMS WORKER G");
    }
    @RabbitListener(queues = "alpha-virtual-academy-sms-queue")
    public void SMSListenerH(SMSTemplate smsTemplate) {
        smsProcessor.processSMS(smsTemplate);
        log.info("SMS WORKER H");
    }
    @RabbitListener(queues = "alpha-virtual-academy-sms-queue")
    public void SMSListenerI(SMSTemplate smsTemplate) {
        smsProcessor.processSMS(smsTemplate);
        log.info("SMS WORKER I");
    }
    @RabbitListener(queues = "alpha-virtual-academy-sms-queue")
    public void SMSListenerJ(SMSTemplate smsTemplate) {
        smsProcessor.processSMS(smsTemplate);
        log.info("SMS WORKER J");
    }

}
