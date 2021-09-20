package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired LogController logController;

	@Test
	void contextLoads() {
		String csvConfig = logController.showCsvConfig();
		System.out.println(csvConfig);
		Assertions.assertTrue(csvConfig.endsWith(".csv"));
	}

}
