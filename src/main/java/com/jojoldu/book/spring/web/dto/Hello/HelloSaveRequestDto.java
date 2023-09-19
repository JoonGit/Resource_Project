package com.jojoldu.book.spring.web.dto.Hello;

import com.jojoldu.book.spring.domain.posts.Entity.TestEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HelloSaveRequestDto {
    private String name;
    private String amount;
    private String date;

    @Builder
    public HelloSaveRequestDto(String name, String amount, String date)
    {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public TestEntity toEntity(){
        return TestEntity.builder()
                .name(name)
                .amount(amount)
                .date(date)
                .build();
    }
}
