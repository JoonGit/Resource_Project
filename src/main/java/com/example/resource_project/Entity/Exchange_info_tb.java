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
public class Exchange_info_tb {

    @Id
    private LocalDate exchange_date_pk;

    @NotNull
    private int exchange_rate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Exchange_tb_currenty_id_pk")
    private Exchange_tb currency_id_pk;

    @Builder
    public Exchange_info_tb(LocalDate exchange_date_pk,
                       int exchange_rate,
                       Exchange_tb currency_id_pk
    ) {
        this.exchange_date_pk = exchange_date_pk;
        this.exchange_rate = exchange_rate;
        this.currency_id_pk = currency_id_pk;
    }


}
