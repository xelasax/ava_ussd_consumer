package com.xdatechnologies.avaconsumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ConfigurationProperties(prefix = "ava.payment")
@Data
public class PaymentPropertiesConfig {
    public String merchantId;
    public String productId;
    public String apiKey;
    public String baseUrl;

    @Bean
    public WebClient BaseClient(){
       return WebClient.create(this.baseUrl);
    }
}
