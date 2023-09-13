package com.example.resource_project.dto.Resource;

import com.example.resource_project.Entity.Resource_tb;
import com.example.resource_project.Entity.Unit_tb;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Resource_tb_save_dto {
    private String resource_eng_name;
    private String resource_kor_name;
    private String resource_symbol;
    private String unit_name;

    @Builder
    public Resource_tb_save_dto(String resource_eng_name,
                                String resource_kor_name,
                                String resource_symbol,
                                String unit_name){
        this.resource_eng_name = resource_eng_name;
        this.resource_kor_name = resource_kor_name;
        this.resource_symbol = resource_symbol;
        this.unit_name = unit_name;
    }

    public Resource_tb to_Resource_tb_entity(){
        return Resource_tb.builder()
                .resourceEngName(resource_eng_name)
                .resourceKorName(resource_kor_name)
                .resourceSymbol(resource_symbol)
                .build();
    }

    public Unit_tb to_Unit_tb_entity(){
        return Unit_tb.builder()
                .unitName(unit_name)
                .build();
    }

}
