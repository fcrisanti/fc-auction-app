package pl.example.fcauctionapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class FCAuctionApp {

	public static void main(String[] args) {
		SpringApplication.run(FCAuctionApp.class, args);
	}
}
