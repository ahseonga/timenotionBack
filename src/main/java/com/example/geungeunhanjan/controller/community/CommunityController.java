package com.example.geungeunhanjan.controller.community;

<<<<<<< HEAD:src/main/java/com/example/geungeunhanjan/controller/CommunityController.java
import com.example.geungeunhanjan.domain.dto.InquiryDTO;
import com.example.geungeunhanjan.mapper.InquiryMapper;
import com.example.geungeunhanjan.service.InquiryService;
=======
import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.service.community.InquiryService;
>>>>>>> 8726178c37a347f042d657a15bd3fbed9e2c27e6:src/main/java/com/example/geungeunhanjan/controller/community/CommunityController.java

import com.example.geungeunhanjan.domain.dto.community.NoticeDTO;
import com.example.geungeunhanjan.service.community.NoticeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD:src/main/java/com/example/geungeunhanjan/controller/CommunityController.java
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> 8726178c37a347f042d657a15bd3fbed9e2c27e6:src/main/java/com/example/geungeunhanjan/controller/community/CommunityController.java

import java.util.List;


// 커뮤티니로

@Controller
@RequestMapping("/community")
public class CommunityController {
    private final InquiryService inquiryService;
    private final NoticeService noticeService;
    private final InquiryMapper inquiryMapper;

    public CommunityController(InquiryService inquiryService, NoticeService noticeService, InquiryMapper inquiryMapper) {
        this.inquiryService = inquiryService;
        this.noticeService = noticeService;
        this.inquiryMapper = inquiryMapper;
    }


    @GetMapping("/inquiry")
    public String community(Model model) {


        List<InquiryDTO> inquiries = inquiryService.selectInquiryAll();

        // 문의 리스트 7개로 제한
        if (inquiries.size() > 7) {
            inquiries = inquiries.subList(0, 7);
        }

        model.addAttribute("inquiries", inquiries);
        return "community/inquiry";
    }


    @GetMapping("/inquiry/{inquiryId}")
    @ResponseBody
    public InquiryDTO inquiryDetail(@PathVariable("inquiryId") Long inquiryId, Model model) {
        return inquiryService.selectInquiryDetail(inquiryId);
    }

    @PostMapping("/inquiry")
    public String community() {
        return "community/inquiry";
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


