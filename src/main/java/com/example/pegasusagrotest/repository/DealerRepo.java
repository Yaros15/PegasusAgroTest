package com.example.pegasusagrotest.repository;

import com.example.pegasusagrotest.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepo extends JpaRepository<Dealer, Long> {
}
