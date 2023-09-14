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
public class ExchangeInfoTb {

    @Id
    private LocalDate exchangeDatePk;

    @NotNull
    private int exchangeRate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ExchangeTbCurrentyIdPk")
    private ExchangeTb currencyIdPk;

    @Builder
    public ExchangeInfoTb(LocalDate exchangeDatePk,
                          int exchangeRate,
                          ExchangeTb currencyIdPk
    ) {
        this.exchangeDatePk = exchangeDatePk;
        this.exchangeRate = exchangeRate;
        this.currencyIdPk = currencyIdPk;
    }


}
