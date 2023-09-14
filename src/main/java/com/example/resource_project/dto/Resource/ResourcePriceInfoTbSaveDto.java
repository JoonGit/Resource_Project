package com.example.resource_project.dto.Resource;


import com.example.resource_project.Entity.ResourceTb;
import com.example.resource_project.Entity.ResourcePriceInfoTb;
import com.example.resource_project.Entity.UnitTb;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@JsonAutoDetect
@Getter
@NoArgsConstructor
public class ResourcePriceInfoTbSaveDto {

    private String resourceDatePk;
    private float price;
    private String resourceTbSymbol;
    private String unitIdName;

    @Builder
    public ResourcePriceInfoTbSaveDto(String resourceDatePk,
                                      float price,
                                      String resourceTbSymbol,
                                      String unitIdName){
        this.resourceDatePk = resourceDatePk;
        this.price = price;
        this.resourceTbSymbol = resourceTbSymbol;
        this.unitIdName = unitIdName;
    }

    public ResourcePriceInfoTb toEntity(LocalDate resourceDatePk,
                                        float price,
                                        ResourceTb resourceIdMk,
                                        UnitTb unitIdFk
                                           ){
        return ResourcePriceInfoTb.builder()
                .resourceDatePk(resourceDatePk)
                .price(price)
                .resourceIdMk(resourceIdMk)
                .unitIdFk(unitIdFk)
                .build();
    }


}
