package com.jojoldu.book.spring.web.dto.Resource;


import com.jojoldu.book.spring.domain.posts.Entity.ResourceCodeEntity;
import com.jojoldu.book.spring.domain.posts.Entity.ResourceInfoEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class resourceInfoSaveDto {
    private List<String> name;
    private List<Float> price;
    private String acquisitionTime;
    private ResourceCodeEntity resourceCodeEntity;

    @Builder
    public resourceInfoSaveDto(List<String> name,List<Float> price, String acquisitionTime){
        this.name = name;
        this.price = price;
        this.acquisitionTime = acquisitionTime;
    }

    public ResourceInfoEntity toEntity(Float price, String acquisitionTime, ResourceCodeEntity Id){
        return ResourceInfoEntity.builder()
                .price(price)
                .acquisitionTime(acquisitionTime)
                .resourceCodeEntity(Id)
                .build();
    }
}
