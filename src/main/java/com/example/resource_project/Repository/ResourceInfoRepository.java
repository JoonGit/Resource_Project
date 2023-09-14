package com.example.resource_project.Repository;


import com.example.resource_project.Entity.ResourcePriceInfoTb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceInfoRepository extends JpaRepository<ResourcePriceInfoTb, Integer> {

}
