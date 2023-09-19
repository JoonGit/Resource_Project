package com.jojoldu.book.spring.Service.posts;

import com.jojoldu.book.spring.domain.posts.Repository.HelloRepository;
import com.jojoldu.book.spring.domain.posts.Entity.TestEntity;
import com.jojoldu.book.spring.web.dto.Hello.HelloSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HelloService {

    private final HelloRepository helloRepository;

    @Transactional
    public Long save(HelloSaveRequestDto requestDto)
    {
        return helloRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public List<TestEntity> read()
    {
        return helloRepository.findAllByOrderByDate();
    }
}
