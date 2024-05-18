package edu.fiu.Group5Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Group5BookstoreApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(Group5BookstoreApplication.class, args);
	}

	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

	@Override
	public void run(String... args) throws Exception {
//		Placed here just in case we need to run something once the application starts
	}
}
