package com.example.geungeunhanjan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myLife")
public class MyPageController {

    @GetMapping("/mypageCommentList")
    public String mypageCommentList(){

        return "myLife/myPageCommentList";
    }

    @GetMapping("/mypageLike")
    public String mypageLike(){

        return "/myLife/myPageLike";
    }

    @GetMapping("/mypageEditMemberInformation")
    public String mypageEditMemberInformation(){
        return "/myLife/myPageEditMemberInformation";
    }

    @GetMapping("/mypageNotification")
    public String mypageNotification(){
        return "/myLife/myPageNotification";
    }

    @GetMapping("/mypagePasswordChange")
    public String changepassword(){
        return "/myLife/mypagePasswordChange";
    }
}

