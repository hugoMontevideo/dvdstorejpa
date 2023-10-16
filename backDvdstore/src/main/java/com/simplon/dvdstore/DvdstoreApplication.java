package com.simplon.dvdstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableFeignClients("com.simplon.dvdstore")
@SpringBootApplication
public class DvdstoreApplication {


	public static void main(String[] args) {
		SpringApplication.run(DvdstoreApplication.class, args);
	}

}
