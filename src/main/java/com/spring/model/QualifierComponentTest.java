package com.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class QualifierComponentTest {

    @Qualifier("jioPhone")
    @Autowired
    Phone jioPhone;

    @Qualifier("samsungPhone")
    @Autowired
    Phone samsungPhone;

    public void run()
    {
        jioPhone.call();
        jioPhone.sms();
        jioPhone.getWhatsAppSMS();
        System.out.println(" +====================== ");
        samsungPhone.call();
        samsungPhone.sms();
        samsungPhone.getWhatsAppSMS();
    }
}
