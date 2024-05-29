package com.example.geungeunhanjan.controller.lifes;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 모두의 일대기로
@Controller
@RequestMapping("/everyLife")
public class EveryLifeController {

    @GetMapping()
    public String everyLife(HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/user/login";
        }
        return "everyLife/everyLife";
    }

    @GetMapping("/detail-others")

    public String everyDetailOthers() {
        return "everyLife/detail-others";
    }
}
