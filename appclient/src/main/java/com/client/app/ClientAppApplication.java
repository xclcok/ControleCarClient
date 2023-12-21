package com.client.app;

import com.client.app.entities.Client;
import com.client.app.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);
	}
	@Bean
	CommandLineRunner inCommandLineRunner(ClientRepository clientRepository){
		return  args -> {
			clientRepository.save(new Client(Long.parseLong("1"),"mousaab",33));
			clientRepository.save(new Client(Long.parseLong("2"),"said",22));
			clientRepository.save(new Client(Long.parseLong("3"),"moussa",23));
			clientRepository.save(new Client(Long.parseLong("4"),"abdo",98));
		};

	}

}
