package com.xdatechnologies.ussd.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xdatechnologies.ussd.collection.Registration;
import com.xdatechnologies.ussd.collection.SchoolRegistration;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@JsonSerialize
public class RegistrationTemplate implements Serializable {
    public static final long serialVersionUID = 42L;
    private final String email;
    private final String subject;
    private final SchoolRegistration schoolRegistration;
    private final Registration registration;

    public RegistrationTemplate(String email, String subject, SchoolRegistration schoolRegistration, Registration registration) {
        this.email = email;
        this.subject = subject;
        this.schoolRegistration = schoolRegistration;
        this.registration = registration;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public SchoolRegistration getSchoolRegistration() {
        return schoolRegistration;
    }

    public Registration getRegistration() {
        return registration;
    }

    @Override
    public String toString() {
        return "RegistrationTemplate{" +
                "email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", schoolRegistration=" + schoolRegistration +
                ", registration=" + registration +
                '}';
    }
}
