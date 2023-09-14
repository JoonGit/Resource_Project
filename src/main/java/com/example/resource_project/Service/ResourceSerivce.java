package com.example.resource_project.Service;


import com.example.resource_project.Entity.ResourcePriceInfoTb;
import com.example.resource_project.Entity.ResourceTb;
import com.example.resource_project.Entity.UnitTb;
import com.example.resource_project.Repository.ResourceTbRepository;
import com.example.resource_project.Repository.ResourceInfoRepository;
import com.example.resource_project.Repository.UnitTbRepository;
import com.example.resource_project.dto.Resource.ResourceTbSaveDto;
import com.example.resource_project.dto.Resource.ResourcePriceInfoTbSaveDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class ResourceSerivce {

    private final ResourceTbRepository tbRepository;
    private final ResourceInfoRepository infoRepository;
    private final UnitTbRepository unitRepository;

    public ResourceSerivce(ResourceTbRepository tbRepository,
                           ResourceInfoRepository infoRepository,
                           UnitTbRepository unitRepository)
    {
        this.tbRepository = tbRepository;
        this.infoRepository = infoRepository;
        this.unitRepository = unitRepository;
    }

    public int ResourceCodeSave(ResourceTbSaveDto requestDto)
    {
        unitRepository.save(requestDto.to_Unit_tb_entity());
        return tbRepository.save(requestDto.to_Resource_tb_entity()).getResourceIdPk();
    }


//    public int ResourceInfoSave(List<Resource_price_info_tb_save_dto> requestDto)
    public int ResourceInfoSave(List<ResourcePriceInfoTbSaveDto> requestDto)
    {
        for (ResourcePriceInfoTbSaveDto dto : requestDto)
        {
            ResourcePriceInfoTb entity = dto.toEntity(
                    LocalDate.parse(dto.getResourceDatePk(), DateTimeFormatter.ISO_DATE),
                    dto.getPrice(),
                    FindIdBySymbol(dto.getResourceTbSymbol()),
                    FindIdByUnit(dto.getUnitIdName()));
            infoRepository.save(entity);
        }
        return 1;
    }

    public String ResourceAll()
    {
        // tb와 info와 unit을 join, 해서 Resource이름을 가져온다
        // resource_price_info_tb에서 resource_tb 조인
        // resource_price_info_tb에서 unit_tb 조인
        // 최초 7개만 반환
        return null;
    }


    public ResourceTb FindIdBySymbol(String Resource_tb_symbol)
    {
        return tbRepository.findByResourceSymbol(Resource_tb_symbol).get();
    }

    public UnitTb FindIdByUnit(String unit_name)
    {
        return unitRepository.findByUnitName(unit_name).get();
    }
}
