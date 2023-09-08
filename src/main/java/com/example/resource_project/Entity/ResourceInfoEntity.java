package com.example.resource_project.Entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ResourceInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float price;
    private String acquisitionTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ResourceCodeEntity_id")
    private ResourceCodeEntity resourceCodeEntity;

    @Builder
    public ResourceInfoEntity(Float price, String acquisitionTime, ResourceCodeEntity resourceCodeEntity) {
        this.price = price;
        this.acquisitionTime = acquisitionTime;
        this.resourceCodeEntity = resourceCodeEntity;
    }

}
