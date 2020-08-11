package com.xdatechnologies.avaconsumer.listener;

import com.xdatechnologies.avaconsumer.service.MailService;
import com.xdatechnologies.ussd.models.EMAILTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailListener {

    private final MailService emailService;

    @Autowired
    public EmailListener(MailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "alpha-virtual-academy-email-queue")
    public void registrationListener(EMAILTemplate emailTemplate){
        log.info(emailTemplate.toString());
        emailService.sendEmail(emailTemplate);
        log.info(" EMAIL WORKER A");
    }
    @RabbitListener(queues = "alpha-virtual-academy-email-queue")
    public void registrationListenerB(EMAILTemplate emailTemplate){
        log.info(emailTemplate.toString());
        emailService.sendEmail(emailTemplate);
        log.info(" EMAIL WORKER B");
    }

    @RabbitListener(queues = "alpha-virtual-academy-email-queue")
    public void registrationListenerC(EMAILTemplate emailTemplate){
        log.info(emailTemplate.toString());
        emailService.sendEmail(emailTemplate);
        log.info(" EMAIL WORKER C");
    }

    @RabbitListener(queues = "alpha-virtual-academy-email-queue")
    public void registrationListenerD(EMAILTemplate emailTemplate){
        log.info(emailTemplate.toString());
        emailService.sendEmail(emailTemplate);
        log.info(" EMAIL WORKER D");
    }

    @RabbitListener(queues = "alpha-virtual-academy-email-queue")
    public void registrationListenerE(EMAILTemplate emailTemplate){
        log.info(emailTemplate.toString());
        emailService.sendEmail(emailTemplate);
        log.info(" EMAIL WORKER E");
    }

}
