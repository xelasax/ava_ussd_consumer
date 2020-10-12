package com.xdatechnologies.avaconsumer;

import com.xdatechnologies.avaconsumer.service.PaymentProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class AvaConsumerApplicationTests {
    @Autowired
    private PaymentProcessor paymentProcessor;

    @Test
    void contextLoads() {
    }

//    @Test
//    void processPayment() {
//        BigDecimal amount = new BigDecimal("1000");
//        System.out.println(amount.toPlainString());
//    }


/*	@Test
	void processPayment() {
		String netWork = paymentProcessor.getNetWork("233277263928");
		assert netWork.equals("AIRTELTIGO");
	}
	@Test
	void formstMSISDN() {
		String netWork = paymentProcessor.formatMSISDN("0207263938","233277263928");
		System.out.println(netWork);
	}*/
}
