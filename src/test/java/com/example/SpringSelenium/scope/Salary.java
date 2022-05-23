package com.example.SpringSelenium.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Salary {
    //@Value("${amount:500}")
    private int amount;

    public int getAmount() {
        return amount;
    }
    //@Value("${amount:500}")
    public void setAmount(int amount) {
        this.amount = amount;
    }
}