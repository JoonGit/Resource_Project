package com.example.resource_project.Repository;


import com.example.resource_project.Entity.ResourceCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResourceCodeRepository extends JpaRepository<ResourceCodeEntity, Long> {
    Optional<ResourceCodeEntity> findByName(String name);


}
