package com.xdatechnologies.avaconsumer.listener;

import com.xdatechnologies.avaconsumer.service.MailService;
import com.xdatechnologies.ussd.models.PAYMENTTemplate;
import com.xdatechnologies.ussd.models.RegistrationTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegistrationListener {

    private final MailService emailService;

    @Autowired
    public RegistrationListener(MailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListener(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER A");
    }
    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListenerB(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER B");
    }

    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListenerC(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER C");
    }
    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListenerD(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER D");
    }
    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListenerE(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER E");
    }
    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListenerF(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER F");
    }
    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListenerG(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER G");
    }
    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListenerH(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER H");
    }
    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListenerI(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER I");
    }
    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListenerJ(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER J");
    }
    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListenerK(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER K");
    }
/*    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListenerL(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER L");
    }
    @RabbitListener(queues = "alpha-virtual-academy-registration-queue")
    public void registrationListenerM(RegistrationTemplate registrationTemplate){
        log.info(registrationTemplate.toString());
       emailService.sendEmail(registrationTemplate);
        log.info("REGISTRATION EMAIL WORKER M");
    }*/
}
