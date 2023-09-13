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
public class Resource_price_info_tb {

    @Id
    private LocalDate resource_date_pk;

    @NotNull
    private float price;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Resource_tb_id")
    private Resource_tb resource_id_mk;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Unit_tb_ubit_id_pk")
    private Unit_tb unit_id_fk;



    @Builder
    public Resource_price_info_tb(Resource_tb resource_id_mk, LocalDate resource_date_pk, float price, Unit_tb unit_id_fk) {
        this.resource_id_mk = resource_id_mk;
        this.resource_date_pk = resource_date_pk;
        this.price = price;
        this.unit_id_fk = unit_id_fk;
    }

}
