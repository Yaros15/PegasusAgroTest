package com.example.pegasusagrotest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "carOwner_id")
    private String carOwnerFullName;

    public Car() {
    }

    public Car(String numberCar, Date buildDate, String carOwnerFullName) {
        this.numberCar = numberCar;
        this.buildDate = buildDate;
        this.carOwnerFullName = carOwnerFullName;
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

    public String getCarOwner() {
        return carOwnerFullName;
    }

    public void setCarOwner(String carOwnerFullName) {
        this.carOwnerFullName = carOwnerFullName;
    }
}
