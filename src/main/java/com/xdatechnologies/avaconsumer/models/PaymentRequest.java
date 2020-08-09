package com.xdatechnologies.avaconsumer.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PaymentRequest {
    private final String merchantId;
    private final String productId;
    private final String refNo;
    private final String msisdn;
    private final String amount;
    private final String network;
    private final String narration;
    private final String apiKey;

}
