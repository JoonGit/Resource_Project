package com.example.resource_project.Repository;


import com.example.resource_project.Entity.ResourceTb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResourceTbRepository extends JpaRepository<ResourceTb, Integer> {
    Optional<ResourceTb> findByResourceSymbol(String Symbol);
}
