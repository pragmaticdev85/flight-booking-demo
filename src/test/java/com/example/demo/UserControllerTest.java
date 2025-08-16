package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.model.responses.PassengerAllowList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class UserControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private UserController userController;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
		assertThat(userController).isNotNull();
		PassengerAllowList passengerAllowList = this.testRestTemplate.getForObject(String.format("http://localhost:%s/passenger/allow-list", port), PassengerAllowList.class);
		final String allowListNames = Arrays.toString(passengerAllowList.getPassengerNames());
		assertThat(allowListNames).isNotNull();
		assertThat(allowListNames).contains("Alice");
		assertThat(allowListNames).contains("Priya");
		assertThat(allowListNames).contains("John");
		log.info("allow-list: " + Arrays.toString(passengerAllowList.getPassengerNames()));
	}
}
