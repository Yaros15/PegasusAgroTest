package com.example.pegasusagrotest.dto;

import java.util.List;

public class DealerDTO {

    private String nameOrganization;
    private String email;
    private String representativeFullName;
    private List<Long> carOwnersId;

    public DealerDTO(String nameOrganization, String email, String representativeFullName, List<Long> carOwnersId) {
        this.nameOrganization = nameOrganization;
        this.email = email;
        this.representativeFullName = representativeFullName;
        this.carOwnersId = carOwnersId;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepresentativeFullName() {
        return representativeFullName;
    }

    public void setRepresentativeFullName(String representativeFullName) {
        this.representativeFullName = representativeFullName;
    }

    public List<Long> getCarOwnersId() {
        return carOwnersId;
    }

    public void setCarOwnersId(List<Long> carOwnersId) {
        this.carOwnersId = carOwnersId;
    }
}
