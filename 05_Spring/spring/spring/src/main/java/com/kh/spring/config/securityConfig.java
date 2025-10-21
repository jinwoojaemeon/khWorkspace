package com.kh.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration    // 해당 객체는 설정을 위한 객체임을 명시
public class securityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable);
        return http.build();
    }

    /*
        매서드 단위로 특정 객체를 만들어 반환하는 형태의 빈 등록 어노테이션
        BCryptPasswordEncoder 객체를 스프링 빈에 등록해서 사용하고 싶다.
        다만 외부객체이므로 class에 직접 @Component를 기술할 수 없어서
        해당 객체를 만들어 반환하는 함수 자체를 Bean에 등록하여 필요 시 스프링이 만들어 전달할 수 있게 한다.
     */
    @Bean
    public BCryptPasswordEncoder BCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
