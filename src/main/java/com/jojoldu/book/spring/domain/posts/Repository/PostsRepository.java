package com.jojoldu.book.spring.domain.posts.Repository;

import com.jojoldu.book.spring.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
