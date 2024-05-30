package com.example.pegasusagrotest.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "CarOwner")
public class CarOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private int telephone;
    private String email;

    @OneToMany(mappedBy = "carOwner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Car> carsInPossession;

    public CarOwner() {
    }

    public CarOwner(String fullName, int telephone, String email, Set<Car> carsInPossession) {
        this.fullName = fullName;
        this.telephone = telephone;
        this.email = email;
        this.carsInPossession = carsInPossession;
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

    public Set<Car> getCarsInPossession() {
        return carsInPossession;
    }

    public void setCarsInPossession(Set<Car> carsInPossession) {
        this.carsInPossession = carsInPossession;
    }
}
