package com.packt.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.packt.cardatabase.web.CarController;

@SpringBootTest
class CardatabaseApplicationTests {
	
	@Autowired
	private CarController controller;

	@Test
	@DisplayName("First example test case") // 해당 애노테이션으로 테스트 케이스의 이름 지정.
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
