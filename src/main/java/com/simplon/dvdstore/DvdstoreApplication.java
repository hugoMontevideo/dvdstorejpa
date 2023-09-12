package com.simplon.dvdstore;

import com.simplon.dvdstore.repositories.DvdModelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DvdstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(DvdstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DvdstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DvdModelRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new DvdModel("rocky", "film"));
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));


		};
	}

	
	
	

}
