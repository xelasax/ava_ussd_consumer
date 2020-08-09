package com.xdatechnologies.avaconsumer.models;

public class SMSInternalCallback {
    private final String response;
    private final String referenceID;

    public SMSInternalCallback(String response, String referenceID) {
    this.response = response;
    this.referenceID = referenceID;
    }

    public String getResponse() {
        return response;
    }

    public String getReferenceID() {
        return referenceID;
    }
}
