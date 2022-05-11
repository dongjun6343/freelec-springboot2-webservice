package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entity와 유사한 형태임에도 Dto클래스를 추가로 생성함.
 * why? Entity클래스는 DB와 맞닿는 핵심 클래스이므로 Request/Response 클래스로 사용해서는 안된다.
 */

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
   private String title;
   private String content;
   private String author;

   @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
       return Posts.builder()
               .title(title)
               .content(content)
               .author(author)
               .build();
    }
}
