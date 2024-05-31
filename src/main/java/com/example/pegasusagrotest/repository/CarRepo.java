package com.example.pegasusagrotest.repository;

import com.example.pegasusagrotest.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, Long> {
}
