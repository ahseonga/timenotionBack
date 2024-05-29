package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.dto.CommentDTO;
import com.example.geungeunhanjan.domain.dto.LikeDTO;
import com.example.geungeunhanjan.service.MyPageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// myLife로 가는 컨트롤러
@Controller
@RequestMapping("/myLife")
public class MyPageController {
    private final MyPageService myPageService;

    public MyPageController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    // 내가 쓴 댓글로
    @GetMapping("/mypageCommentList")
    public String mypageCommentList(Model model, HttpSession session){
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        List<CommentDTO> comments = myPageService.selectMyComment(userId);
        model.addAttribute("comments", comments);
        return "myLife/myPageCommentList";
    }

    // 좋아요 목록으로
    @GetMapping("/mypageLike")
    public String mypageLike(Model model, HttpSession session){
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        List<LikeDTO> likes = myPageService.selectMyLike(userId);
        model.addAttribute("likes", likes);

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

