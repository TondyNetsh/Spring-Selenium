package com.example.SpringSelenium.condition;

import com.example.SpringSelenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class CarTest extends SpringBaseTestNGTest {
    @Autowired
    private Car car;

    @Test
    public void carTest() throws InterruptedException {
        this.car.run();
    }
}
