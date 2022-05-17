package com.jojoldu.book.springboot.service.posts;


import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsListResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * update : JPA는 영속성 컨텍스트가 있다.
 * JPA의 엔티티 매니저(EntityManager)가 활성화된 상태로 트랜잭션 안에서 디비에 데이터를 가져오면 영속성 컨텍스트가 유지된 상태가 됨.
 * 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영. ==> 즉, UPDATE 쿼리를 날릴 필요가 없다
 * 이것을 더티 체킹이라고 한다.
 */

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){

        Posts posts = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new
                IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }


    /**
     * postRepository에서 넘어온 결과를
     * Stream을 통해 map으로 new PostsListResponseDto 에 매핑 해준다.
     * 1) postsRepository.findAllDesc().stream()
     *
     * PostsListResponseDto에서는 파라미터로 postRepository에서 넘어온 결과 Posts entity를 받고 있으므로
     * .map(entity -> new PostsListResponseDto(entity)) ==> .map(PostsListResponseDto::new)
     *
     * collect를 사용해서 List로 변환한다.
     * .collect(Collectors.toList());
     * @return
     */

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDESC().stream()
                .map(PostsListResponseDto::new).collect(Collectors.toList());
//      return postsRepository.findAllDESC().stream().map(entity -> new PostsListResponseDto(entity)).
//               collect(Collectors.toList());

    }
}
