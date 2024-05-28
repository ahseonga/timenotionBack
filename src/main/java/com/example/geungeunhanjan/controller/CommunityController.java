package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.dto.InquiryDTO;
import com.example.geungeunhanjan.service.InquiryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// 커뮤티니로
@Controller
@RequestMapping("/community")
public class CommunityController {
    private final InquiryService inquiryService;

    public CommunityController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
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

    @GetMapping("/notification")
    public String notification() {
        return "community/notification";
    }

    @GetMapping("/notification/community_detail")
    public String notificationDetail() {
        return "community/community_detail";
    }


}
