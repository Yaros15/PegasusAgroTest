package com.example.pegasusagrotest.controller;

import com.example.pegasusagrotest.dto.DealerDTO;
import com.example.pegasusagrotest.model.CarOwner;
import com.example.pegasusagrotest.model.Dealer;
import com.example.pegasusagrotest.repository.CarOwnerRepo;
import com.example.pegasusagrotest.repository.DealerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealer")
public class DealerController{

    private final DealerRepo dealerRepo;
    private final CarOwnerRepo carOwnerRepo;

    @Autowired

    public DealerController(DealerRepo dealerRepo, CarOwnerRepo carOwnerRepo) {
        this.dealerRepo = dealerRepo;
        this.carOwnerRepo = carOwnerRepo;
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

    public Dealer convertDTOInModelDealer(DealerDTO dealerDTO){
        Dealer dealer = new Dealer();
        dealer.setNameOrganization(dealerDTO.getNameOrganization());
        dealer.setEmail(dealerDTO.getEmail());
        dealer.setRepresentativeFullName(dealerDTO.getRepresentativeFullName());
        dealer.setServesCarOwners(carOwnerRepo.findAllById(dealerDTO.getCarOwnersId()));
        return dealer;
    }

    @PostMapping
    public Dealer createDealer(@RequestBody DealerDTO dealerDTO){
        return dealerRepo.save(convertDTOInModelDealer(dealerDTO));
    }

    @PutMapping("{id}")
    public Dealer updateDealer(@PathVariable("id") Long dealerId, @RequestBody DealerDTO dealerDTO){
        Dealer dealer = convertDTOInModelDealer(dealerDTO);
        dealer.setId(dealerId);
        return dealerRepo.save(dealer);
    }

    @DeleteMapping("{id}")
    public void deleteDealer(@PathVariable("id") Long dealerId){
        dealerRepo.deleteById(dealerId);
    }

    @PutMapping("{dealerId}/remove/{carOwnerId}")
    public Dealer removeCarOwnerFromDealer(@PathVariable("dealerId") Long dealerId,
                                           @PathVariable("carOwnerId") Long carOwnerId){
        Dealer dealer = dealerRepo.findById(dealerId).orElse(null);
        if(dealer != null){
            dealer.getServesCarOwners().removeIf(carOwner -> carOwner.getId()==carOwnerId);
            dealerRepo.save(dealer);
        }
        return dealer;
    }

}
