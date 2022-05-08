package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @RestController : 컨트롤러 JSON을 반환하는 컨트롤러를 만들어 준다.
 *  예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있도록 해준다고 생각.
 *
 *  @GetMapping : HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
 *  예전에는 @RequestMapping(method = RequestMethod.GET) 사용되었다.
 *  이제 이 프로젝트에서는 /hello로 요청이 오면 문자열 hello를 반환하는 기능을 갖게 됨.
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
