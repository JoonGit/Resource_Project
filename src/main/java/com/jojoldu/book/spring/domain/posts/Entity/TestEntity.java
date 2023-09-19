package com.jojoldu.book.spring.domain.posts.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String amount;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String date;

    @Builder
    public TestEntity(String name, String amount, String date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }
}
