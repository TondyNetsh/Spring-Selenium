package com.example.SpringSelenium;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringSeleniumApplicationTests {
	@Autowired
	private User user;
	@Autowired
	private Television tv;

	@Value("${TEST_URL:https://www.google.co.za}")
	private String path;

	@Value("${fruits}")
	private List<String> fruits;

	@Value("${myusername}")
	private String username;

	@Test
	void contextLoads() {
		user.printDetails();
		System.out.println(this.path);
		System.out.println(this.fruits);
		System.out.println(this.username);

		Faker faker = new Faker();
		System.out.println(faker.name().firstName());

		this.tv.playMovie();
	}

	/*
		@Test
		void contextLoads() {
			Address address = new Address();
			Salary salary = new Salary();
			User user = new User(address, salary);
			user.printDetails();
		}
	 */
}
