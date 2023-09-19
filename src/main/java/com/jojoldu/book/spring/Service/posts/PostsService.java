package com.jojoldu.book.spring.Service.posts;

import com.jojoldu.book.spring.domain.posts.Posts;
import com.jojoldu.book.spring.domain.posts.Repository.PostsRepository;
import com.jojoldu.book.spring.web.dto.Post.PostsResponseDto;
import com.jojoldu.book.spring.web.dto.Post.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long updata(Long id, PostsSaveRequestDto requestDto)
    {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }


    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }

    public Long delete(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이없습니다. id="+ id));

        postsRepository.delete(entity);
        return 0L;
    }
}
