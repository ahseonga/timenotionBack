package com.example.geungeunhanjan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class HomeController {

    @GetMapping("/main")
    public String main() {
        return "main/main";
    }

    @GetMapping("/about")
    public String about(){
        return "main/about";
    }

    @GetMapping("/mypage")
    public String mypage(){
        return "myLife/mypage";
    }

    @GetMapping("/detail_writingMode")
    public String detailWritingMode(){
        return "myLife/detail_writingMode";
    }

    @GetMapping("/detail-my")
    public String detailMy(){
        return "myLife/detail-my";
    }

    @GetMapping("/yourLife")
    public String yourLife(){
        return "yourLife/yourLife";
    }

    @GetMapping("/everyLife")
    public String everyLife(){
        return "everyLife/everyLife";
    }

    @GetMapping("/inquiry")
    public String inquiry(){
        return "community/inquiry";
    }

}