package com.spring.model;

import org.springframework.stereotype.Component;

@Component
public abstract class Phone {

    void call() {
        System.out.println(" Phone Call ");
    }

    void sms() {
        System.out.println(" Phone sms ");
    }

    void getWhatsAppSMS() {
        System.out.println(" Phone WhatsApp SMSes ");
    }
}
