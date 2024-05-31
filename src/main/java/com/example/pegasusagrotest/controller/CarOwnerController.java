package com.example.pegasusagrotest.controller;

import com.example.pegasusagrotest.model.CarOwner;
import com.example.pegasusagrotest.repository.CarOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carOwner")
public class CarOwnerController {

    private final CarOwnerRepo carOwnerRepo;

    @Autowired
    public CarOwnerController(CarOwnerRepo carOwnerRepo){
        this.carOwnerRepo = carOwnerRepo;
    }

    @GetMapping
    public List<CarOwner> listOfCarOwner(){
        return carOwnerRepo.findAll();
    }

    @GetMapping("{id}")
    public CarOwner findCarOwnerById (@PathVariable("id") Long ownerId){
        CarOwner currentOwner = carOwnerRepo.findById(ownerId).orElse(null);
        return currentOwner;
    }

    @PostMapping
    public CarOwner createCarOwner(@RequestBody CarOwner carOwner){
        return carOwnerRepo.save(carOwner);
    }

    @PutMapping("{id}")
    public CarOwner updateCarOwner(@PathVariable("id") Long ownerId, @RequestBody CarOwner carOwner){
        carOwner.setId(ownerId);
        return carOwnerRepo.save(carOwner);
    }

    @DeleteMapping("{id}")
    public void deleteCarOwner(@PathVariable("id") Long ownerId){
        carOwnerRepo.deleteById(ownerId);
    }

}