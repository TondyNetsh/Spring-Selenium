package com.example.SpringSelenium.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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