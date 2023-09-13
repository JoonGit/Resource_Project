package com.example.resource_project.Service;


import com.example.resource_project.Entity.Resource_price_info_tb;
import com.example.resource_project.Entity.Resource_tb;
import com.example.resource_project.Entity.Unit_tb;
import com.example.resource_project.Repository.Resource_tb_repository;
import com.example.resource_project.Repository.Resource_info_repository;
import com.example.resource_project.Repository.Unit_tb_repository;
import com.example.resource_project.dto.Resource.Resource_tb_save_dto;
import com.example.resource_project.dto.Resource.Resource_price_info_tb_save_dto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class Resource_serivce {

    private final Resource_tb_repository tbRepository;
    private final Resource_info_repository infoRepository;
    private final Unit_tb_repository unitRepository;

    public Resource_serivce(Resource_tb_repository tbRepository,
                            Resource_info_repository infoRepository,
                            Unit_tb_repository unitRepository)
    {
        this.tbRepository = tbRepository;
        this.infoRepository = infoRepository;
        this.unitRepository = unitRepository;
    }

    public int ResourceCodeSave(Resource_tb_save_dto requestDto)
    {
        unitRepository.save(requestDto.to_Unit_tb_entity());
        return tbRepository.save(requestDto.to_Resource_tb_entity()).getResource_id_pk();
    }


//    public int ResourceInfoSave(List<Resource_price_info_tb_save_dto> requestDto)
    public int ResourceInfoSave(Resource_price_info_tb_save_dto requestDto)
    {
//        for (Resource_price_info_tb_save_dto dto : requestDto)
//        {
//            Resource_price_info_tb entity = dto.toEntity(
//                    LocalDate.parse(dto.getResource_date_pk(), DateTimeFormatter.ISO_DATE),
//                    dto.getPrice(),
//                    FindIdBySymbol(dto.getResource_tb_symbol()),
//                    FindIdByUnit(dto.getUnit_id_name()));
//            infoRepository.save(entity);
//        }

                    Resource_price_info_tb entity = requestDto.toEntity(
                    LocalDate.parse(requestDto.getResource_date_pk(), DateTimeFormatter.ISO_DATE),
                            requestDto.getPrice(),
                    FindIdBySymbol(requestDto.getResource_tb_symbol()),
                    FindIdByUnit(requestDto.getUnit_id_name()));
            infoRepository.save(entity);
        return 1;
    }


    public Resource_tb FindIdBySymbol(String Resource_tb_symbol)
    {
        return tbRepository.findByResourceSymbol(Resource_tb_symbol).get();
    }

    public Unit_tb FindIdByUnit(String unit_name)
    {
        return unitRepository.findByUnitName(unit_name).get();
    }
}
