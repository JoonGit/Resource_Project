package com.example.resource_project.Repository;

import com.example.resource_project.Entity.ExchangeInfoTb;
import com.example.resource_project.Entity.ExchangeTb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeTbRepository extends JpaRepository<ExchangeTb, Integer> {
        Optional<ExchangeTb> findByCurrencyName(String Name);
}
