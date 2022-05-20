package com.example.SpringSelenium.condition;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@Qualifier("accord")
public class Accord implements Car{
    @Override
    public void run() {
        System.out.println("This is accord. Speed is 80 mph");
    }
}