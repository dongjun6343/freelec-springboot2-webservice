package com.jojoldu.book.springboot.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * assertThat : 테스트 검증 라이브러리의 검증 메서드
 * isEqualTo : assertThat의 동등 비교 메서드로 assertThat에 있는 값을 비교해서 같을 때만 성공.
 *
 * 테스트 시 에러발생 => 확인해보니 gradle 버전이 5이상이면 Lombok의 의존성 추가하는 방법이 달라졌기 때문에
 */

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);

    }
}