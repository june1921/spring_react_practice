package com.packt.cardatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.packt.cardatabase.web.CarController;

@SpringBootTest
class CardatabaseApplicationTests {
	
	@Autowired
	private CarController controller;

	@Test
	void contextLoads() {
	}

}
