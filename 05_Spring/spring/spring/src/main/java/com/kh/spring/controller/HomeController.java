package com.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // mapping을 해주는 controller임을 알려주는 어노테이션
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }
}
