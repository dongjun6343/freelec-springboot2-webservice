package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Posts 클래스로 DB를 접근하게 해줄 JpaRepository 생성.
 * 보통 ibatis나 MyBatis 등에서 Dao라고 불리는 DB Layer 접근자.
 * JpaRepository<Entity클래스, PK타입> 을 상속하면 기본적으로 CRUD메소드가 자동으로 생성된다.
 */

public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDESC();

}
