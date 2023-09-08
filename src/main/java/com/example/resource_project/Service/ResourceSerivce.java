package com.example.resource_project.Service;


import com.example.resource_project.Entity.ResourceCodeEntity;
import com.example.resource_project.Entity.ResourceInfoEntity;
import com.example.resource_project.Repository.ResourceCodeRepository;
import com.example.resource_project.Repository.ResourceInfoRepository;
import com.example.resource_project.dto.Resource.resourceCodeSaveDto;
import com.example.resource_project.dto.Resource.resourceInfoSaveDto;
import org.springframework.stereotype.Service;


@Service
public class ResourceSerivce {

    private final ResourceCodeRepository codeRepository;
    private final ResourceInfoRepository infoRepository;

    public ResourceSerivce(ResourceCodeRepository codeRepository,
                           ResourceInfoRepository infoRepository)
    {
        this.codeRepository = codeRepository;
        this.infoRepository = infoRepository;
    }

    public Long ResourceInfoSave(resourceInfoSaveDto requestDto)
    {
        for (int i = 0; i < requestDto.getName().size(); i++)
        {
            ResourceInfoEntity entity =requestDto.toEntity(requestDto.getPrice().get(i),
                    requestDto.getAcquisitionTime(),
                    FindIdByName(requestDto.getName().get(i)));
            infoRepository.save(entity);
            System.out.println(entity);
        }
        return 1L;
    }

    public Long ResourceCodeSave(resourceCodeSaveDto requestDto)
    {
        requestDto.toEntity();
        return codeRepository.save(requestDto.toEntity()).getId();
    }
    public ResourceCodeEntity FindIdByName(String name)
    {
        return codeRepository.findByName(name).get();
    }
}
