package com.car.car.service;

import com.car.car.service.entities.Car;
import com.car.car.service.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(5000);
		requestFactory.setReadTimeout(5000);
		restTemplate.setRequestFactory(requestFactory);
		return restTemplate;
	}
	@Bean
	CommandLineRunner inCommandLineRunner(CarRepository carRepository){
		return  args -> {
			carRepository.save(new Car(Long.parseLong("1"),"TOYOTA","2012C","1SS5BC",Long.parseLong("1")));
			carRepository.save(new Car(Long.parseLong("2"),"MERCEDES","2446C","9N30BC",Long.parseLong("2")));
			carRepository.save(new Car(Long.parseLong("3"),"AUDI","8991A","EF550",Long.parseLong("3")));

		};

	}
}
