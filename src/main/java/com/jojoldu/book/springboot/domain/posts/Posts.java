package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *  @Entity : 테이블과 링크될 클래스.
 *  네이밍 EX) SalesManager.java => sales_manager table
 *
 * @Id : 해당 테이블의 PK
 *
 * @GeneratedValue : PK의 생성 규칙을 나타냄.
 * strategy = GenerationType.IDENTITY ==> auto_increment
 *
 * @Column : 테이블의 칼럼을 나타냄
 * 선언을 하지 않으면 해당 클래스의 필드는 모두 컬럼이 된다.
 *
 * @NoArgsConstructor : 기본 생성자 자동 추가
 * public Posts(){} 와 같다
 *
 * @Builder : 해당 클래스의 빌더 패턴 클래스 생성
 * 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
 *
 * Setter메서드가 없다 why? ==> 해당 클래스의 인스턴스 값들이 어디에서 변경되는지 명확하게 구분할 수 없다.
 * 만약 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메서드를 추가해야 함.
 *
 * Ex) 잘못 사용된 예
 * public class Order{
 *     public void setStatus(boolean status){
 *         this.status = status
 *     }
 * }
 *
 * public void 주문서비스의_취소이벤트(){
 *     order.setStatus(false);
 * }
 * 
 * Ex) 올바른 사용 예
 * public class Order {
 *     public void cancelOrder(){
 *         this.status = false;
 *     }
 * }
 *
 * public void 주문서비스의_취소이벤트(){
 *     order.cancelOrder();
 * }
 */

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
