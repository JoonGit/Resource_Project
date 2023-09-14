package com.example.resource_project.Repository;

import com.example.resource_project.Entity.UnitTb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitTbRepository extends JpaRepository<UnitTb, Integer> {

    Optional<UnitTb> findByUnitName(String unit_name);
}
