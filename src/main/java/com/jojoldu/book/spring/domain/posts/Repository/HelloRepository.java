package com.jojoldu.book.spring.domain.posts.Repository;

import com.jojoldu.book.spring.domain.posts.Entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HelloRepository extends JpaRepository<TestEntity, Long> {
    List<TestEntity> findAllByOrderByDate();
}
