package com.example.SpringSelenium.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnExpression("${car.speed} < 70")
public class Civic implements Car{
    @Override
    public void run() throws InterruptedException {
        Thread.sleep(7000);
        System.out.println("This is accord. Speed is 60 mph");
    }
}
