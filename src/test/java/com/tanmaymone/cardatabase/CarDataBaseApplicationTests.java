package com.tanmaymone.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tanmaymone.cardatabase.web.CarController;

@SpringBootTest
class CarDataBaseApplicationTests {
	@Autowired
	private CarController controller;
	@Test
	@DisplayName("First example test case")
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
