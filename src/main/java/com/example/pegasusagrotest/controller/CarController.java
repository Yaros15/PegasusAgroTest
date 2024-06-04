package com.example.pegasusagrotest.controller;

import com.example.pegasusagrotest.model.Car;
import com.example.pegasusagrotest.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarRepo carRepo;

    @Autowired
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
/*
    public Car convertDTOInModelCar (CarDTO carDTO){
        CarOwner carOwner = carOwnerRepo.findById(carDTO.getCarOwnerId()).orElse(null);
        Car car = new Car();
        if(carOwner != null) {
            car.setCarOwnerFullName(carOwner.getFullName());
        }else{
            car.setCarOwnerFullName("Диллер");
        }
        car.setNumberCar(carDTO.getNumberCar());
        car.setBuildDate(carDTO.getBuildDate());
        return car;
    }
*/
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
    public ResponseEntity<String> deleteCar(@PathVariable("id") Long carId){
        Car car = carRepo.findById(carId).orElse(null);
        if(car == null){
            return ResponseEntity.badRequest().body(String.format("Машины с номером ид: %d - нет в базе данных", carId));
        }
        carRepo.deleteById(carId);
        return ResponseEntity.ok("Машина удалена");
    }

}
