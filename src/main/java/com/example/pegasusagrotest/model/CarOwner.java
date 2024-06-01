package com.example.pegasusagrotest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CarOwner")
public class CarOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private int telephone;
    private String email;

    @OneToMany
    @JoinColumn(name = "Car_id")
    private List<Car> carsInUse;

    public CarOwner() {
    }

    public CarOwner(String fullName, int telephone, String email, List<Car> carsInUse) {
        this.fullName = fullName;
        this.telephone = telephone;
        this.email = email;
        this.carsInUse = carsInUse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Car> getCarsInUse() {
        return carsInUse;
    }

    public void setCarsInUse(List<Car> carsInUse) {
        this.carsInUse = carsInUse;
    }
}
