package com.xdatechnologies.avaconsumer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private String responseCode;
    private String responseMessage;
    private String uniwalletTransactionId;
}
