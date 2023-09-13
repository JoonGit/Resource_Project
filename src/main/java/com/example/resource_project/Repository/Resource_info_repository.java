package com.example.resource_project.Repository;


import com.example.resource_project.Entity.Resource_price_info_tb;
import com.example.resource_project.Entity.Resource_tb;
import com.example.resource_project.Entity.Unit_tb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Resource_info_repository extends JpaRepository<Resource_price_info_tb, Integer> {







}
