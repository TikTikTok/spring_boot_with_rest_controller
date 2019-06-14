package com.spring.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("jioPhone")
public class JioPhone extends Phone {
    @Override
    public void call() {
        System.out.println(" Jio Phone Call ");
    }

    @Override
    public void sms() {
        System.out.println(" Jio Phone SMS ");
    }

    public void getInternetAccess()
    {
        System.out.println(" Jio Phone Internet ");
    }
}
