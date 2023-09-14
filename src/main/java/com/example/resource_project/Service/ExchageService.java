package com.example.resource_project.Service;

import com.example.resource_project.Entity.ExchangeTb;
import com.example.resource_project.Entity.UnitTb;
import com.example.resource_project.Repository.ExchangeInfoTbRepository;
import com.example.resource_project.Repository.ExchangeTbRepository;
import com.example.resource_project.Repository.ResourceInfoRepository;
import com.example.resource_project.dto.Resource.ExchageInfoTbSaveDto;
import com.example.resource_project.dto.Resource.ExchageTbSaveDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ExchageService {

    private final ExchangeTbRepository tbRepository;
    private final ExchangeInfoTbRepository infoRepository;

    public ExchageService(
            ExchangeTbRepository tbRepository,
            ExchangeInfoTbRepository infoRepository
    )
    {
        this.tbRepository = tbRepository;
        this.infoRepository = infoRepository;
    }

    public void TbSave(ExchageTbSaveDto requestDto)
    {
        tbRepository.save(requestDto.toEntity());
    }

    public void InfoSave(ExchageInfoTbSaveDto requestDto)
    {
        infoRepository.save(requestDto.toEntity(
                LocalDate.parse(requestDto.getExchangeDatePk(), DateTimeFormatter.ISO_DATE)
                ,findByCurrencyName(requestDto.getCurrencyName())));
    }

    public ExchangeTb findByCurrencyName(String CurrencyName) {
        return tbRepository.findByCurrencyName(CurrencyName).get();
    }
}
