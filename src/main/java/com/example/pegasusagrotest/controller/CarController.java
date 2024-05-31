package com.example.pegasusagrotest.controller;

import com.example.pegasusagrotest.model.Car;
import com.example.pegasusagrotest.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Car")
public class CarController {

    @Autowired
    public final CarRepo carRepo;

    public CarController(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @GetMapping
    public List<Car> listOfCar(){
        return carRepo.findAll();
    }

    @GetMapping("{id}")
    public Car findCarById (@PathVariable("id") Long carId){
        Car currentCar = carRepo.findById(carId).orElse(null);
        return currentCar;
    }

    @PostMapping
    public Car createCar(@RequestBody Car car){
        return carRepo.save(car);
    }

    @PutMapping("{id}")
    public Car updateCar(@PathVariable("id") Long carId, @RequestBody Car car){
        car.setId(carId);
        return carRepo.save(car);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable("id") Long carId){
        carRepo.deleteById(carId);
    }

}
