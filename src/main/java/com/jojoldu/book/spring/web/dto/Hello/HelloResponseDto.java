package com.jojoldu.book.spring.web.dto.Hello;

import com.jojoldu.book.spring.domain.posts.Entity.TestEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private Long id;
    private String name;
    private String amount;

    public HelloResponseDto(TestEntity entity)
    {
        this.id = entity.getId();
        this.name = entity.getName();
        this.amount = entity.getAmount();
    }




}
