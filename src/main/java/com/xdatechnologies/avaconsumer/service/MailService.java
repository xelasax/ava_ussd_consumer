package com.xdatechnologies.avaconsumer.service;

import com.xdatechnologies.ussd.models.EMAILTemplate;
import com.xdatechnologies.ussd.models.RegistrationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender mailSender;

    @Autowired
    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(RegistrationTemplate registrationTemplate){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(registrationTemplate.getEmail());
        simpleMailMessage.setSubject(registrationTemplate.getSubject());
        String body="Good day, \n\nKindly find below details of a potential student or school \n\n";
        if (registrationTemplate.getRegistration() != null){
            body +="STUDENT DETAILS : \n";
            body += "Name :" + registrationTemplate.getRegistration().getFullName() + "\n";
            body += "Course Group :" + registrationTemplate.getRegistration().getCourseGroup() + "\n";
            body += "Class Group :" + registrationTemplate.getRegistration().getCourseType() + "\n";
            body += "Class  :" + registrationTemplate.getRegistration().getSection() + "\n";
            body += "Contact :" + registrationTemplate.getRegistration().getContact() + "\n";
            body += "Phone Number of the person that did the registration :" + registrationTemplate.getRegistration().getRequestMsisdn() + "\n";

        }else if (registrationTemplate.getSchoolRegistration() != null){
            body +="SCHOOL DETAILS : \n\n";
            body += "Name of School : " + registrationTemplate.getSchoolRegistration().getNameOfSchool() + "\n";
            body += "Location : " + registrationTemplate.getSchoolRegistration().getLocationOfSchool() + "\n";
            body += "Contact Person : " + registrationTemplate.getSchoolRegistration().getNameOfContactPerson() + "\n";
            body += "Phone Number of Contact Person : " + registrationTemplate.getSchoolRegistration().getPhoneNumberOfContactPerson() + "\n";
            body += "Phone Number of the person that did the registration : " + registrationTemplate.getSchoolRegistration().getRequestMSISDN();
        }

        simpleMailMessage.setText(body);
        mailSender.send(simpleMailMessage);
    }


    public void sendEmail(EMAILTemplate emailTemplate){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emailTemplate.getEmail());
        simpleMailMessage.setSubject(emailTemplate.getSubject());
        String body="Kindly find the details below \n\n";
        simpleMailMessage.setText(body + emailTemplate.getEmailBody());
        mailSender.send(simpleMailMessage);
    }
}
