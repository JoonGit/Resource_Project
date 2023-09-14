package com.example.resource_project.Entity;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class ResourcePriceInfoTb {

    @Id
    private LocalDate resourceDatePk;

    @NotNull
    private float price;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ResourceTbId")
    private ResourceTb resourceIdMk;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UnitTbUbitIdPk")
    private UnitTb unitIdFk;



    @Builder
    public ResourcePriceInfoTb(ResourceTb resourceIdMk,
                               LocalDate resourceDatePk,
                               float price,
                               UnitTb unitIdFk) {
        this.resourceIdMk = resourceIdMk;
        this.resourceDatePk = resourceDatePk;
        this.price = price;
        this.unitIdFk = unitIdFk;
    }

}
