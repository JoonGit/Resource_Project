package com.jojoldu.book.spring.domain.posts.Repository.Resource;

import com.jojoldu.book.spring.domain.posts.Entity.ResourceCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResourceCodeRepository extends JpaRepository<ResourceCodeEntity, Long> {
    Optional<ResourceCodeEntity> findByName(String name);


}
