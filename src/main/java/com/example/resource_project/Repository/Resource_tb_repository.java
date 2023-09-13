package com.example.resource_project.Repository;


import com.example.resource_project.Entity.Resource_tb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Resource_tb_repository extends JpaRepository<Resource_tb, Integer> {

    Optional<Resource_tb> findByResourceSymbol(String name);


    //    Optional<Resource_tb> findByResource_tb_symbol(String name);
}
