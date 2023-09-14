package com.example.resource_project.Repository;

import com.example.resource_project.Entity.ExchangeInfoTb;
import com.example.resource_project.Entity.ResourceTb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ExchangeInfoTbRepository extends JpaRepository<ExchangeInfoTb, Integer> {

}
