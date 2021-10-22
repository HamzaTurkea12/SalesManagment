package com.testhamza.hamza;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class HamzaApplication {

	public static void main(String[] args) {

		SpringApplication.run(HamzaApplication.class, args);
		Logger logger = (Logger) LoggerFactory.getLogger(SaleService.class);
		logger.info("bad requset");
	}


}
