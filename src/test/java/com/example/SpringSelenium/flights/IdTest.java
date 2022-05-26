package com.example.SpringSelenium.flights;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"app.locale=id","browser=firefox"})
public class IdTest extends FlightTest {
}