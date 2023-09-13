package com.example.resource_project.dto.Resource;


import com.example.resource_project.Entity.Resource_tb;
import com.example.resource_project.Entity.Resource_price_info_tb;
import com.example.resource_project.Entity.Unit_tb;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@JsonAutoDetect
@Getter
@NoArgsConstructor
public class Resource_price_info_tb_save_dto {

    private String resource_date_pk;
    private float price;
    private String resource_tb_symbol;
    private String unit_id_name;

    @Builder
    public Resource_price_info_tb_save_dto(String resource_date_pk,
                                           float price,
                                           String resource_tb_symbol,
                                           String unit_id_name){
        this.resource_date_pk = resource_date_pk;
        this.price = price;
        this.resource_tb_symbol = resource_tb_symbol;
        this.unit_id_name = unit_id_name;
    }

    public Resource_price_info_tb toEntity(LocalDate resource_date_pk,
                                           float price,
                                           Resource_tb resource_id_mk,
                                           Unit_tb unit_id_fk
                                           ){
        return Resource_price_info_tb.builder()
                .resource_date_pk(resource_date_pk)
                .price(price)
                .resource_id_mk(resource_id_mk)
                .unit_id_fk(unit_id_fk)
                .build();
    }


}
