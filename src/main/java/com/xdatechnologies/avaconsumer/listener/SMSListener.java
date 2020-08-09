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

}
