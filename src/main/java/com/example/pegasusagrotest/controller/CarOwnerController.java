package com.example.pegasusagrotest.controller;

import com.example.pegasusagrotest.dto.CarOwnerDTO;
import com.example.pegasusagrotest.model.Car;
import com.example.pegasusagrotest.model.CarOwner;
import com.example.pegasusagrotest.repository.CarOwnerRepo;
import com.example.pegasusagrotest.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carOwner")
public class CarOwnerController {

    private final CarOwnerRepo carOwnerRepo;
    private final CarRepo carRepo;

    @Autowired
    public CarOwnerController(CarOwnerRepo carOwnerRepo, CarRepo carRepo){
        this.carOwnerRepo = carOwnerRepo;
        this.carRepo = carRepo;
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

    public CarOwner convertDTOInModelCarOwner(CarOwnerDTO carOwnerDTO){
        CarOwner carOwner = new CarOwner();
        carOwner.setFullName(carOwnerDTO.getFullName());
        carOwner.setTelephone(carOwnerDTO.getTelephone());
        carOwner.setEmail(carOwnerDTO.getEmail());
        carOwner.setCarsInUse(carRepo.findAllById(carOwnerDTO.getCarId()));
        return carOwner;
    }

    public void convertDTOInModelCar(CarOwnerDTO carOwnerDTO, CarOwner carOwner){
        for (Long oneCarId : carOwnerDTO.getCarId()){
            Car currentCar = carRepo.findById(oneCarId).orElse(null);
            if(currentCar != null){
                currentCar.setCarOwner(carOwner.getFullName());
                carRepo.save(currentCar);
            }
        }
    }

    @PostMapping
    public CarOwner createCarOwner(@RequestBody CarOwnerDTO carOwnerDTO){
        CarOwner currentCarOwner = carOwnerRepo.save(convertDTOInModelCarOwner(carOwnerDTO));
        convertDTOInModelCar(carOwnerDTO, currentCarOwner);
        return currentCarOwner;
    }

    @PutMapping("{id}")
    public CarOwner updateCarOwner(@PathVariable("id") Long ownerId, @RequestBody CarOwnerDTO carOwnerDTO){
        CarOwner carOwner = convertDTOInModelCarOwner(carOwnerDTO);
        carOwner.setId(ownerId);
        convertDTOInModelCar(carOwnerDTO, carOwner);
        return carOwnerRepo.save(carOwner);
    }

    @DeleteMapping("{id}")
    public void deleteCarOwner(@PathVariable("id") Long ownerId){
        carOwnerRepo.deleteById(ownerId);
    }

}