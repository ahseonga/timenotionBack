package com.example.geungeunhanjan.controller.community;


import com.example.geungeunhanjan.domain.dto.community.*;
import com.example.geungeunhanjan.domain.dto.page.Criteria;
import com.example.geungeunhanjan.domain.dto.page.Page;
import com.example.geungeunhanjan.mapper.community.InquiryMapper;
import com.example.geungeunhanjan.service.community.InquiryService;

import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.service.community.InquiryService;


import com.example.geungeunhanjan.service.community.NoticeService;

import com.example.geungeunhanjan.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


// 커뮤티니로

@Controller
@RequestMapping("/community")
public class CommunityController {
    private final InquiryService inquiryService;
    private final NoticeService noticeService;
    private final InquiryMapper inquiryMapper;
    private final UserService userService;

    public CommunityController(InquiryService inquiryService, NoticeService noticeService, InquiryMapper inquiryMapper, UserService userService) {
        this.inquiryService = inquiryService;
        this.noticeService = noticeService;
        this.inquiryMapper = inquiryMapper;
        this.userService = userService;
    }


    @GetMapping("/inquiry")
    public String community(Criteria criteria, Model model) {
        List<InquiryPagingDTO> inquiries = inquiryService.selectAllInquiryPage(criteria);
        int total = inquiryService.selectInquiryTotal();
        Page page = new Page(criteria, total);

        model.addAttribute("inquiries", inquiries);
        model.addAttribute("page", page);

        System.out.println(total);
        System.out.println("page = " + page);
        
        return "/community/inquiry";
//
//        List<InquiryDTO> inquiries = inquiryService.selectInquiryAll();
//
//
//        model.addAttribute("inquiries", inquiries);
//        return "community/inquiry";
    }




    @GetMapping("/inquiry/{inquiryId}")
    @ResponseBody
    public InquiryDTO inquiryDetail(@PathVariable("inquiryId") Long inquiryId) {
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


    @PostMapping("/inquiry/deleteInquiry")
    public ResponseEntity<String> deleteInquiry(@RequestParam("inquiryId") Long inquiryId, @RequestParam("userId") Long userId) {
        // inquiryId와 userId를 사용하여 삭제 작업 수행
        inquiryMapper.inquiryDelete(inquiryId, userId);
        // 응답에 성공 메시지를 포함하여 반환
        return ResponseEntity.ok("삭제 완료");
    }

    @PostMapping("/inquiry/insertInquiry")
    public String insertInquiry(@ModelAttribute ("inquiryWriteDTO") InquiryWriteDTO inquiryWriteDTO, @SessionAttribute("userId") Long userId){

        String userNickname = userService.selectUserNickname(userId);;

        inquiryWriteDTO.setUserId(userId);
        System.out.println(userId);
        inquiryWriteDTO.setUserNickname(userNickname);
//        inquiryDTO.setInquiryCreatedDate();
        LocalDateTime currentDateTime = LocalDateTime.now();
        inquiryWriteDTO.setInquiryCreatedDate(currentDateTime);
//        inquiryWriteDTO.setInquiryCreatedDate(new Date().);


        inquiryService.inquiryWrite(inquiryWriteDTO);

        return "redirect:/community/inquiry";
    }
}


