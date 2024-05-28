package com.example.geungeunhanjan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// myLife로 가는 컨트롤러
@Controller
@RequestMapping("/myLife")
public class MyPageController {

    // 내가 쓴 댓글로
    @GetMapping("/mypageCommentList")
    public String mypageCommentList(){

        return "myLife/myPageCommentList";
    }

    // 좋아요 목록으로
    @GetMapping("/mypageLike")
    public String mypageLike(){

        return "/myLife/myPageLike";
    }

    // 회원정보 수정으로
    @GetMapping("/mypageEditMemberInformation")
    public String mypageEditMemberInformation(){
        return "/myLife/myPageEditMemberInformation";
    }

    // 알림으로
    @GetMapping("/mypageNotification")
    public String mypageNotification(){
        return "/myLife/myPageNotification";
    }

    // 비밀번호 변경으로
    @GetMapping("/mypagePasswordChange")
    public String changepassword(){
        return "/myLife/mypagePasswordChange";
    }
}

