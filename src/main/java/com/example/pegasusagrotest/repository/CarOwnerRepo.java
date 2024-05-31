package com.example.pegasusagrotest.repository;

import com.example.pegasusagrotest.model.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerRepo extends JpaRepository<CarOwner, Long> {
}
