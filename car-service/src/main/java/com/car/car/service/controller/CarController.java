package com.car.car.service.controller;


import com.car.car.service.entities.CarResponse;
import com.car.car.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List<CarResponse> findAll(){
        return carService.findAll();
    }
    @GetMapping("/{id}")
    public CarResponse findById(@PathVariable Long id) throws  Exception{
        return carService.findById(id);
    }
}
