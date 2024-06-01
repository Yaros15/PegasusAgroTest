package com.example.pegasusagrotest.dto;

import java.util.List;

public class CarOwnerDTO {

    private String fullName;
    private int telephone;
    private String email;
    private List<Long> carsId;

    public CarOwnerDTO(String fullName, int telephone, String email, List<Long> carsId) {
        this.fullName = fullName;
        this.telephone = telephone;
        this.email = email;
        this.carsId = carsId;
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

    public List<Long> getCarId() {
        return carsId;
    }

    public void setCarId(List<Long> carsId) {
        this.carsId = carsId;
    }
}
