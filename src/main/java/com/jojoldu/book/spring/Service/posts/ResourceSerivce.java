package com.jojoldu.book.spring.Service.posts;

import com.jojoldu.book.spring.domain.posts.Entity.ResourceCodeEntity;
import com.jojoldu.book.spring.domain.posts.Entity.ResourceInfoEntity;
import com.jojoldu.book.spring.domain.posts.Repository.Resource.ResourceCodeRepository;
import com.jojoldu.book.spring.domain.posts.Repository.Resource.ResourceInfoRepository;
import com.jojoldu.book.spring.web.dto.Resource.resourceCodeSaveDto;
import com.jojoldu.book.spring.web.dto.Resource.resourceInfoSaveDto;
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
