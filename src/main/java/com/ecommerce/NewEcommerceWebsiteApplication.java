package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class NewEcommerceWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewEcommerceWebsiteApplication.class, args);
		

	}
	
	@Bean
	public BCryptPasswordEncoder passWordEncoderInstance()
	{
		System.out.println("Password Encoder Bean created");
		return new BCryptPasswordEncoder();
	}

}
