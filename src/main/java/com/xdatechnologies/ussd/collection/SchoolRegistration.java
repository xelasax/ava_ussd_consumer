package com.xdatechnologies.ussd.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolRegistration implements Serializable {

    private String id;
    private String nameOfSchool;
    private String locationOfSchool;
    private String nameOfContactPerson;
    private String phoneNumberOfContactPerson;
    private String requestMSISDN;
}
