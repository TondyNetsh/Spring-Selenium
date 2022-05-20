package com.example.SpringSelenium.condition;

import com.example.SpringSelenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

public class CarTest extends SpringBaseTestNGTest {
    @Qualifier("civic")

    @Autowired
    private Car car;

    @Test
    public void carTest() throws InterruptedException {
        this.car.run();
    }
}
