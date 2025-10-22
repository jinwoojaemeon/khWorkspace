package com.kh.spring.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

/*
    로깅(logging)이란?
    실행 중에 발생하는 상태, 동작, 예외, 요청흐름을 파악하거나 기록할 때 사용하는 것
    개발중에는 디버깅용으로 사용하고, 운영중에는ㄴ 에러를 분석하는 용도로 사용한다.

    System.out.println() : 출력 위치가 무조건 콘솔에서 진행, 로그 구분이 불가능하고, 출력용으로 문자열 연산 성능이 좋지 않다.
                            로그를 기록하는 용도로 사용 시 관리가 어렵고 분석도 어렵다.

    log.info
    log.debug
    log.error
               : 콘솔, 파일, 외부 시스템 등 다양하게 출력할 수 있고 로그를 구분하여 출력할 수 있다. ([LEVEL]  INFO, DEBUG, ERROR 등 ... )
                 로그를 파일로 관리할 수 있기 때문에 검색하고 분석하기 용이하다. >> 성능 손실이 적다.

                 Slf4j : 로깅 인터페이스(표준) -> 어떤 구현체를 사용할지는 어떤 라이브러리를 설치하냐에 따라 달라진다.
                 LogBack : 실제 로그를 파일, 콘솔에 출력하는 구현체

                 spring boot에선는 별도의 설정없이 SLF4J + Logback 조합의 사용이 용이하다.
 */

/*
    요청-응답까지의 시간을 측정하는 필터
    모든 HTTP 요청에 대해서 처리한다.
 */
@Slf4j
@Component
public class RequestTimeFilter implements Filter {

    //private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RequestTimeFilter.class);   >> lombok이 @Slf4j어노테이션으로 자동으로 만들어준다.
    /*
        해당 필터에서 사용할 로직을 작성하는 매서드
        해당 매서드는 DispatcherServlet 호출 전에 실행이 된다.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 요청시작 시간 기록
        long startTime = System.currentTimeMillis();

        String method = request.getMethod();
        String url =  request.getRequestURI();
        String queryString =  request.getQueryString();
        String fullUrl = request.getRequestURL() + (queryString != null ? "?" + queryString : "");

        try{
            filterChain.doFilter(servletRequest, servletResponse);
        }finally {
            // 요청 종료 시간 기록
            long endTime = System.currentTimeMillis();
            long  duration = endTime - startTime;

            int status = response.getStatus(); // 완료된 상태 코드

            //log.info("[GET] login.me - Status: 200 - duration: 10ms");
            log.info("[{}] {} - Status: {} - duration: {}ms", method, fullUrl, status, duration);
        }

    }
}
