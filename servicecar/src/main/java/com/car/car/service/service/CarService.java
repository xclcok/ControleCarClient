package com.car.car.service.service;


import com.car.car.service.entities.Car;
import com.car.car.service.entities.CarResponse;
import com.car.car.service.entities.Client;
import com.car.car.service.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8888/SERVICE-CLIENT";

    public List<CarResponse> findAll() {
        List<Car> cars = carRepository.findAll();
        ResponseEntity<Client[]> response =
                restTemplate.getForEntity(this.URL + "/api/clients", Client[].class);
        Client[] clients = response.getBody();
        return  cars.stream().map((Car car)-> mapToCarResponse(car,clients)).toList();
    }
private CarResponse mapToCarResponse(Car car , Client[] clients){
        Client foundClient = Arrays.stream(clients)
                .filter(client -> client.getId().equals(car.getClient_id()))
                .findFirst()
                .orElse(null);
        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .client(foundClient)
                .matricule(car.getMatricule())
                .model(car.getModel())
                .build();

}
public CarResponse findById(Long id) throws  Exception{
        Car car = carRepository.findById(id).orElseThrow(()->
                new Exception(("Invalide car id!")));
        Client client = restTemplate.getForObject(this.URL+"/api/"+car.getClient_id(), Client.class);
        return CarResponse.builder()
                .id((Long)car.getId())
                .brand(car.getBrand())
                .client(client)
                .matricule(car.getMatricule())
                .model(car.getModel())
                .build();
}

}
    // this function allow the change the Car Entity to A Model that we will send ot the client side using the @Builder Annotation

