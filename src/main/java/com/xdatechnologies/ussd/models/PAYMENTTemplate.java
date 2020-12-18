package com.xdatechnologies.ussd.models;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonSerialize
public class PAYMENTTemplate implements Serializable {
    public static final long serialVersionUID = 42L;
    private final String refNo; // Database ID
    private final String msisdn; // Payment msisdn
    private final String amount; // amount
    private final String narration; // description
    private final String requestMSISDN;
    private final String network;
}
