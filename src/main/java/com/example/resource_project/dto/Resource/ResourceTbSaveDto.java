package com.example.resource_project.dto.Resource;

import com.example.resource_project.Entity.ResourceTb;
import com.example.resource_project.Entity.UnitTb;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResourceTbSaveDto {
    private String resourceEngName;
    private String resourceKorName;
    private String resourceSymbol;
    private String unitName;

    @Builder
    public ResourceTbSaveDto(String resourceEngName,
                             String resourceKorName,
                             String resourceSymbol,
                             String unitName){
        this.resourceEngName = resourceEngName;
        this.resourceKorName = resourceKorName;
        this.resourceSymbol = resourceSymbol;
        this.unitName = unitName;
    }

    public ResourceTb to_Resource_tb_entity(){
        return ResourceTb.builder()
                .resourceEngName(resourceEngName)
                .resourceKorName(resourceKorName)
                .resourceSymbol(resourceSymbol)
                .build();
    }

    public UnitTb to_Unit_tb_entity(){
        return UnitTb.builder()
                .unitName(unitName)
                .build();
    }

}
