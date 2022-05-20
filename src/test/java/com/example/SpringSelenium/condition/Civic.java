package com.example.SpringSelenium.condition;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@Qualifier("civic")
public class Civic implements Car{
    @Override
    public void run() throws InterruptedException {
        Thread.sleep(7000);
        System.out.println("This is civic. Speed is 60 mph");
    }
}
