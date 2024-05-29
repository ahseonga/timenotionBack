package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.dto.InquiryDTO;
import com.example.geungeunhanjan.mapper.InquiryMapper;
import com.example.geungeunhanjan.service.InquiryService;

import com.example.geungeunhanjan.domain.dto.NoticeDTO;
import com.example.geungeunhanjan.service.NoticeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


