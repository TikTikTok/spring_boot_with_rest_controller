package com.spring.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("samsungPhone")
public class SamsungPhone extends Phone {

    @Override
    public void call() {
        System.out.println(" Samsung Phone Call ");
    }

    @Override
    public void sms() {
        System.out.println(" Samsung Phone SMS ");
    }
}
