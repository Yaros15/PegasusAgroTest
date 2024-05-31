package com.example.pegasusagrotest.controller;

import com.example.pegasusagrotest.model.Dealer;
import com.example.pegasusagrotest.repository.DealerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealer")
public class DealerController{

    private final DealerRepo dealerRepo;

    @Autowired

    public DealerController(DealerRepo dealerRepo) {
        this.dealerRepo = dealerRepo;
    }

    @GetMapping
    public List<Dealer> listOfDealer(){
        return dealerRepo.findAll();
    }

    @GetMapping("{id}")
    public Dealer findDealerById (@PathVariable("id") Long dealerId){
        Dealer currentDealer = dealerRepo.findById(dealerId).orElse(null);
        return currentDealer;
    }

    @PostMapping
    public Dealer createDealer(@RequestBody Dealer dealer){
        return dealerRepo.save(dealer);
    }

    @PutMapping("{id}")
    public Dealer updateDealer(@PathVariable("id") Long dealerId, @RequestBody Dealer dealer){
        dealer.setId(dealerId);
        return dealerRepo.save(dealer);
    }

    @DeleteMapping("{id}")
    public void deleteDealer(@PathVariable("id") Long dealerId){
        dealerRepo.deleteById(dealerId);
    }


}
