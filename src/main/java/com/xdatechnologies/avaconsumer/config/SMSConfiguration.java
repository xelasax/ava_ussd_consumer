package com.xdatechnologies.avaconsumer.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ava.sms")
@Data
public class SMSConfiguration {
    private String baseUrl;
    private String username;
    private String password;
    private String type;
    private String dlr;
    private String source;

}
