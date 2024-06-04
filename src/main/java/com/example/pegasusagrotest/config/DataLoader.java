package com.example.pegasusagrotest.config;

import com.example.pegasusagrotest.model.Car;
import com.example.pegasusagrotest.model.CarOwner;
import com.example.pegasusagrotest.model.Dealer;
import com.example.pegasusagrotest.repository.CarOwnerRepo;
import com.example.pegasusagrotest.repository.CarRepo;
import com.example.pegasusagrotest.repository.DealerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private final CarRepo carRepo;
    @Autowired
    private final CarOwnerRepo carOwnerRepo;
    @Autowired
    private final DealerRepo dealerRepo;

    public DataLoader(CarRepo carRepo, CarOwnerRepo carOwnerRepo, DealerRepo dealerRepo) {
        this.carRepo = carRepo;
        this.carOwnerRepo = carOwnerRepo;
        this.dealerRepo = dealerRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initCarTable();
        initCarOwnerTable();
        initDealerTable();
    }

    public void initCarTable(){
        carRepo.save(new Car("1234АВ", new Date(), "Иванов Иван Иванович"));
        carRepo.save(new Car("5678ЕК", new Date(), "Иванов Иван Иванович"));
        carRepo.save(new Car("9123МН", new Date(), "Сергеев Сергей Сергеевич"));
        carRepo.save(new Car("4567ОР", new Date(1212121212121L), "Сергеев Сергей Сергеевич"));
    }

    public void initCarOwnerTable(){
        carOwnerRepo.save(new CarOwner("Иванов Иван Иванович", 11111111,
                "ivanov@mail.ru", new ArrayList<>(Arrays.asList(carRepo.findById(1L).orElse(null), carRepo.findById(2L).orElse(null)))));
        carOwnerRepo.save(new CarOwner("Сергеев Сергей Сергеевич", 22222222,
                "sergeev@mail.ru", new ArrayList<>(Arrays.asList(carRepo.findById(3L).orElse(null), carRepo.findById(4L).orElse(null)))));
        carOwnerRepo.save(new CarOwner("Александров Александр Александрович", 33333333, "alexandrov@mail.ru", null));
    }

    public void initDealerTable(){
        dealerRepo.save(new Dealer("Агро-Дилер 1", "agr_dil@mail.ru",
                "Андреев Андрей Андреевич", new ArrayList<>(Arrays.asList(carOwnerRepo.findById(1L).orElse(null), carOwnerRepo.findById(2L).orElse(null)))));
        dealerRepo.save(new Dealer("Дилер-Агро 2",
                "dil_agr@mail.ru", "Семенов Семен Семенович", null));
    }

}
