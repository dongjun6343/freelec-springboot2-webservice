package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  @SpringBootApplication : 프로젝트 최상단에 위치. (메인 클래스)
 *                              스프링 부트의 자동설정 및 스프링 Bean 읽기, 생성 설정.
 *     SpringApplication.run : 내장 WAS 실행. (내장 WAS - 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부 WAS를 실행한다.)
 *     스프링부트에서는 내장 WAS 사용을 권장함. Why? 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있기 때문에.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
