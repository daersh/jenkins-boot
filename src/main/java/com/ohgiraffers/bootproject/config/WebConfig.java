package com.ohgiraffers.bootproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
    *  Rest-API 서버측에서 CORS 처리를 위한 설정 클래스이다.
* */

@Configuration
@EnableWebMvc     // 어노테이션만 주석처리하면 여기 코드 안돌아가게 할 수 있다~~!
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
//                        "*"
        //                추후 docker 포트 맞춰서 할 것
//                        ,"http://localhost:8011"
//                        쿠버네티스 환경에서 프론트의 워크노드 가리키는 포트 번호(30000). 백엔드 입장에서는 워커노드를 CORS 처리하기 위함
                        "http://localhost:30000"
                )
                .allowedMethods("GET","POST","PUT","DELETE")
                .allowedHeaders("Authorization", "Content-Type")
                .exposedHeaders("Custom-Header")
                .allowCredentials(false)
                .maxAge(3600);
    }
}
