package com.springboot.SpringBootXMLClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.springboot"})
@ComponentScan("com.springboot")
public class SpringBootXmlClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootXmlClientApplication.class, args);
	}

}
