package com.example.resource_project.dto.Resource;

import com.example.resource_project.Entity.ResourceCodeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class resourceCodeSaveDto {
    private String name;
    private float firstPrice;
    private String unit;

    @Builder
    public resourceCodeSaveDto(String name, float firstPrice, String unit){
        this.name = name;
        this.firstPrice = firstPrice;
        this.unit = unit;
    }

    public ResourceCodeEntity toEntity(){
        return ResourceCodeEntity.builder()
                .name(name)
                .firstPrice(firstPrice)
                .unit(unit)
                .build();
    }

}
