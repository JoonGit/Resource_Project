package com.example.resource_project.dto.Resource;


import com.example.resource_project.Entity.ExchangeInfoTb;
import com.example.resource_project.Entity.ExchangeTb;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;

@JsonAutoDetect
@Getter
@NoArgsConstructor
public class ExchageInfoTbSaveDto {
    private String  exchangeDatePk;
    private int exchangeRate;
    private String currencyName;

    @Builder
    public ExchageInfoTbSaveDto(
            String exchangeDatePk,
            int exchangeRate,
            String currencyName)
    {
        this.exchangeDatePk = exchangeDatePk;
        this.exchangeRate = exchangeRate;
        this.currencyName = currencyName;
    }

    public ExchangeInfoTb toEntity(LocalDate exchangeDatePk,ExchangeTb currencyIdPk)
    {
        return ExchangeInfoTb.builder()
                .exchangeDatePk(exchangeDatePk)
                .exchangeRate(exchangeRate)
                .currencyIdPk(currencyIdPk)
                .build();
    }
}
