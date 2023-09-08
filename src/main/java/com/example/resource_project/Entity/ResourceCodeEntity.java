package com.example.resource_project.Entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class ResourceCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float firstPrice;
    private String unit;

    @Builder
    public ResourceCodeEntity(String name, float firstPrice, String unit) {
        this.name = name;
        this.firstPrice = firstPrice;
        this.unit = unit;
    }
}
