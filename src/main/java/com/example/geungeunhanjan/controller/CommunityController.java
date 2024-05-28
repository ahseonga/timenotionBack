package com.example.geungeunhanjan.controller;

<<<<<<< HEAD
import com.example.geungeunhanjan.domain.dto.InquiryDTO;
import com.example.geungeunhanjan.service.InquiryService;
=======
import com.example.geungeunhanjan.domain.dto.NoticeDTO;
import com.example.geungeunhanjan.service.NoticeService;
>>>>>>> 7bc2f127f563150cc982edd7850fb3ad34eb85b5
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

<<<<<<< HEAD
// 커뮤티니로
=======
>>>>>>> 7bc2f127f563150cc982edd7850fb3ad34eb85b5
@Controller
@RequestMapping("/community")
public class CommunityController {
    private final InquiryService inquiryService;

    public CommunityController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

<<<<<<< HEAD
    @GetMapping("/inquiry")
    public String community(Model model) {


        List<InquiryDTO> inquiries = inquiryService.selectInquiryAll();

        // 문의 리스트 7개로 제한
        if (inquiries.size() > 7) {
            inquiries = inquiries.subList(0, 7);
        }

        model.addAttribute("inquiries", inquiries);
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


<<<<<<< HEAD
=======



>>>>>>> 7bc2f127f563150cc982edd7850fb3ad34eb85b5
}
