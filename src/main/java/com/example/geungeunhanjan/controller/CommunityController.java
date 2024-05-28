package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.dto.NoticeDTO;
import com.example.geungeunhanjan.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/community")
public class CommunityController {

<<<<<<< HEAD
    @GetMapping("/inquiry")
    public String community() {

        return "community/inquiry";
=======
    private final NoticeService noticeService;

    public CommunityController (NoticeService noticeService) {
        this.noticeService = noticeService;
>>>>>>> 7bc2f127f563150cc982edd7850fb3ad34eb85b5
    }

    //공지버튼 클릭시
    @GetMapping("/notification")
    public String notification(Model model) {

        List<NoticeDTO> notices = noticeService.selectNoticeAll();
        model.addAttribute("notices", notices);

        return "community/notification";
    }

    //공지페이지 리스트 클릭시
    @GetMapping("/notification/community_detail/{noticeId}")
    public String notificationDetail(Model model, @PathVariable("noticeId") long noticeId) {

        NoticeDTO notice = noticeService.selectNoticeDetail(noticeId);

        model.addAttribute("notice", notice);

        return "community/community_detail";
    }





}


