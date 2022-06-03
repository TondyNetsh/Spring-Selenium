package com.example.SpringSelenium;

import com.example.SpringSelenium.entity.User;
import com.example.SpringSelenium.page.visa.VisaRegistrationPage;
import com.example.SpringSelenium.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;

public class UserVisaTest extends SpringBaseTestNGTest {
    @Autowired
    private VisaRegistrationPage registrationPage;

    @Autowired
    private UserRepository repository;

    @Test
    public void visaTest() throws InterruptedException {
        System.out.println(this.repository.findAll().size());
        this.repository.findById(85).ifPresent(u -> System.out.println(u.getFirstName()));
        List<User> users = this.repository.findAll().stream().limit(3).collect(Collectors.toList());

        for(User u : users) {
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            Thread.sleep(2000);
            this.registrationPage.setFromCountryFromAndTo(u.getFromCountry(),u.getToCountry());
            Thread.sleep(2000);
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            Thread.sleep(2000);
            this.registrationPage.setContactDetails(u.getEmail(),u.getPhone());
            Thread.sleep(2000);
            this.registrationPage.setComments(u.getComments());
            Thread.sleep(2000);
            this.registrationPage.submit();

            System.out.println(this.registrationPage.getConfirmationNumber());
        }
    }
}
