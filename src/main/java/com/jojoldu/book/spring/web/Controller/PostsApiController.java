package com.jojoldu.book.spring.web.Controller;

import com.jojoldu.book.spring.Service.posts.PostsService;
import com.jojoldu.book.spring.web.dto.Post.PostsResponseDto;
import com.jojoldu.book.spring.web.dto.Post.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto)
    {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long Update(@PathVariable Long id, @RequestBody PostsSaveRequestDto requestDto)
    {
        return postsService.updata(id, requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)
    {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long Delete(@PathVariable Long id)
    {
        return postsService.delete(id);
    }

}
