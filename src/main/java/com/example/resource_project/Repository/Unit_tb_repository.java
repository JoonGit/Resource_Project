package com.example.resource_project.Repository;

import com.example.resource_project.Entity.Resource_price_info_tb;
import com.example.resource_project.Entity.Unit_tb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Unit_tb_repository extends JpaRepository<Unit_tb, Integer> {

    Optional<Unit_tb> findByUnitName(String unit_name);
}
