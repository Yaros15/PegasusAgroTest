package com.example.pegasusagrotest.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Dealer")
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameOrganization;
    private String email;
    private String representativeFullName;

    @OneToMany
    @JoinColumn(name = "CarOwner_id")
    private Set<CarOwner> servesCarOwners;

    public Dealer() {
    }

    public Dealer(String nameOrganization, String email, String representativeFullName, Set<CarOwner> servesCarOwners) {
        this.nameOrganization = nameOrganization;
        this.email = email;
        this.representativeFullName = representativeFullName;
        this.servesCarOwners = servesCarOwners;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<CarOwner> getServesCarOwners() {
        return servesCarOwners;
    }

    public void setServesCarOwners(Set<CarOwner> servesCarOwners) {
        this.servesCarOwners = servesCarOwners;
    }
}
