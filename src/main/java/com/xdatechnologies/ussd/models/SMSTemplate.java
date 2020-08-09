package com.xdatechnologies.ussd.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SMSTemplate implements Serializable {
    static final long serialVersionUID = 42L;
    private String msisdn;
    private String messageContent;
    private String referenceID;

}