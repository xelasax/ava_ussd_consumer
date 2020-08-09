package com.xdatechnologies.avaconsumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ava.ussd.amqp")
@Data
public class AMQPPropertiesConfig {
    private String exchange;
    private String smsQueue;
    private String smsRoutingKey;
    private String paymentQueue;
    private String paymentRoutingKey;
    private String registrationQueue;
    private String registrationRoutingKey;
    private String emailQueue;
    private String emailRoutingKey;
}
