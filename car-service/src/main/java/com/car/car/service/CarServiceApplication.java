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
			carRepository.save(new Car(Long.parseLong("1"),"bmw","serie1","7shs",Long.parseLong("1")));
			carRepository.save(new Car(Long.parseLong("2"),"mercedes","class a","ujs",Long.parseLong("2")));
			carRepository.save(new Car(Long.parseLong("3"),"peugeout","hui","ssns9",Long.parseLong("3")));

		};

	}
}
