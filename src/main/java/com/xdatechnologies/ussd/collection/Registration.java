package com.xdatechnologies.ussd.collection;

import lombok.Data;

import java.io.Serializable;

@Data
public class Registration implements Serializable {

    private String id;
    private String courseGroup; //fulltime or part time
    private String courseType; // class category
    private String fullName;
    private String section;
    private String contact;
    private String requestMsisdn;
}
