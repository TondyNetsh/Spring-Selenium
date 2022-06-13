package com.example.SpringSelenium;

import com.example.SpringSelenium.entity.User;
import com.example.SpringSelenium.page.visa.VisaRegistrationPage;
import com.example.SpringSelenium.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserVisaTest extends SpringBaseTestNGTest {
    private static final Logger logger = LoggerFactory.getLogger(UserVisaTest.class);
    @Autowired
    private VisaRegistrationPage registrationPage;

    @Autowired
    private UserRepository repository;

    @Test
    public void visaTest() throws InterruptedException {
        System.out.println(this.repository.findAll().size());
        this.repository.findById(85).ifPresent(u -> System.out.println(u.getFirstName()));
        List<User> users = this.repository.findByDobBetween(Date.valueOf("1995-01-01"), Date.valueOf("1999-01-01")).stream().limit(3).collect(Collectors.toList());

        for(User u : users) {
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            Thread.sleep(500);
            this.registrationPage.setFromCountryFromAndTo(u.getFromCountry(),u.getToCountry());
            Thread.sleep(500);
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            Thread.sleep(500);
            this.registrationPage.setContactDetails(u.getEmail(),u.getPhone());
            Thread.sleep(500);
            this.registrationPage.setComments(u.getComments());
            Thread.sleep(500);
            this.registrationPage.submit();

            logger.info("Request confirmation number # INFO: " + this.registrationPage.getConfirmationNumber());
            logger.warn("Request confirmation number # WARN: " + this.registrationPage.getConfirmationNumber());
            //System.out.println(this.registrationPage.getConfirmationNumber());
        }
    }

    @DataProvider
    public Object[] getData(ITestContext context) {
        return this.repository.findByDobBetween(
                Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
                Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo"))
        ).stream().limit(3).toArray();
    }
}
