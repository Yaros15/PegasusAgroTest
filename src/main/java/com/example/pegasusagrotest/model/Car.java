package com.example.pegasusagrotest.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String numberCar;
    private Date buildDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CarOwner_id")
    private CarOwner carOwner;

    public Car() {
    }

    public Car(String numberCar, Date buildDate, CarOwner carOwner) {
        this.numberCar = numberCar;
        this.buildDate = buildDate;
        this.carOwner = carOwner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }
}
