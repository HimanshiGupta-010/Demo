package com.assign.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.assign.item.Payload"})
public class ItemApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(ItemApplication.class, args);
	}
}