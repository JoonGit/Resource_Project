package com.jojoldu.book.spring.web.Controller;

import com.jojoldu.book.spring.Service.posts.HelloService;
import com.jojoldu.book.spring.domain.posts.Entity.TestEntity;
import com.jojoldu.book.spring.web.dto.Hello.HelloSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(originPatterns = "http://222.98.255.30:3000")
//@CrossOrigin(originPatterns = "http://localhost:3000")
@CrossOrigin(originPatterns = "*")
@RequiredArgsConstructor
@RestController
public class HelloController {
    private final HelloService helloService;
        @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/hello/save")
//    public Long helloResponseDto(@RequestBody HelloSaveRequestDto requestDto  )
    public Long save(@RequestBody HelloSaveRequestDto requestDto )
    {
        return helloService.save(requestDto);
    }

    @GetMapping("/hello/read")
    public List<TestEntity> read()
    {
        return helloService.read();
    }
}