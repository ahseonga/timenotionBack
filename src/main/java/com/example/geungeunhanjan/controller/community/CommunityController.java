package com.example.geungeunhanjan.controller.community;



import com.example.geungeunhanjan.domain.dto.community.*;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryPage;
import com.example.geungeunhanjan.mapper.community.InquiryMapper;
import com.example.geungeunhanjan.service.community.InquiryService;

import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;


import com.example.geungeunhanjan.service.community.NoticeService;

import com.example.geungeunhanjan.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.geungeunhanjan.domain.dto.NoticePage.NoticeCriteria;
import com.example.geungeunhanjan.domain.dto.NoticePage.NoticePage;
import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;
import com.example.geungeunhanjan.domain.vo.community.NoticeVO;
import com.example.geungeunhanjan.mapper.community.NoticeMapper;
import com.example.geungeunhanjan.service.community.InquiryService;


import com.example.geungeunhanjan.domain.dto.community.NoticeDTO;
import com.example.geungeunhanjan.service.community.NoticeService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;



import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


// 커뮤티니

@Controller
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {
    private final InquiryService inquiryService;
    private final NoticeService noticeService;

    private final InquiryMapper inquiryMapper;
    private final UserService userService;



    @GetMapping("/inquiry")
    public String community (InquiryCriteria inquiryCriteria, Model model, HttpSession session){

        List<InquiryPagingDTO> inquiries = inquiryService.selectAllInquiryPage(inquiryCriteria);
        Long loginUserId = (Long) session.getAttribute("uniId");

        int total = inquiryService.selectInquiryTotal();

        InquiryPage inquiryPage = new InquiryPage(inquiryCriteria, total);

        model.addAttribute("inquiries", inquiries);
        model.addAttribute("inquiryPage", inquiryPage);
        model.addAttribute("loginUserId", loginUserId);




        return "/community/inquiry";
    }


    @GetMapping("/inquiry/{inquiryId}")
    @ResponseBody
    public InquiryDTO inquiryDetail (@PathVariable("inquiryId") Long inquiryId, Model model){

        Long inquiryUserId = inquiryService.selectUserIdByInquiryId(inquiryId);

        model.addAttribute("inquiryUserId", inquiryUserId);
        System.out.println("inquiryUserId = " + inquiryUserId);

        return inquiryService.selectInquiryDetail(inquiryId);
    }


    //공지버튼 클릭시
    @GetMapping("/notification")
    public String notification (Model model, NoticeCriteria noticeCriteria, HttpServletRequest request){

        //로그인 한 유저의 userId 를 같이 보냄
        //userId = 1인 회원만 작성 삭제 가능
        Long loggedInUserId = (Long) request.getSession().getAttribute("uniId");
        model.addAttribute("loggedInUserId", loggedInUserId);

        //공지 리스트 정보 가져오기
//        List<NoticeDTO> notices = noticeService.selectNoticeAll();
//        model.addAttribute("notices", notices);

        // 페이지 처리
        List<NoticePageDTO> noticeLists = noticeService.selectAllPageNotice(noticeCriteria);
        System.out.println("noticeLists" + noticeLists);
        int total = noticeService.selectTotalNotice();
        System.out.println("total :" + total);
        NoticePage noticePage = new NoticePage(noticeCriteria, total);
        System.out.println(noticePage);


        //페이징 정보 가져오기
        model.addAttribute("noticeLists", noticeLists);
        model.addAttribute("page", noticePage);


        return "community/notification";
    }

    //공지 삭제시
    @PostMapping("/notification/{noticeId}")
    public String notification ( @PathVariable("noticeId") long noticeId){
//        System.out.println(noticeId);
        noticeService.deleteNotice(noticeId);
        return "redirect:/community/notification";
    }

    //공지페이지 리스트 클릭시
    @GetMapping("/notification/community_detail/{noticeId}")
    public String notificationDetail (Model model,@PathVariable("noticeId") long noticeId){

        NoticeDTO notice = noticeService.selectNoticeDetail(noticeId);

        model.addAttribute("notice", notice);

        return "community/community_detail";
    }


    @PostMapping("/inquiry/deleteInquiry")
    public ResponseEntity<String> deleteInquiry (@RequestParam("inquiryId") Long
                                                         inquiryId, @RequestParam("userId") Long userId){
        // inquiryId와 userId를 사용하여 삭제 작업 수행
        inquiryMapper.inquiryDelete(inquiryId, userId);
        // 응답에 성공 메시지를 포함하여 반환
        return ResponseEntity.ok("삭제 완료");
    }

    @PostMapping("/inquiry/insertInquiry")
    public String insertInquiry (@ModelAttribute("inquiryWriteDTO") InquiryWriteDTO
                                         inquiryWriteDTO, @SessionAttribute("uniId") Long userId){

        String userNickname = userService.selectUserNickname(userId);
        ;

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

    @GetMapping("/notification/notification-detail")
    public String notificationDetail () {
        return "community/notification-detail";
    }

    //    @PostMapping("/notification/notification-detail")
//    public String insertNotice(@ModelAttribute("noticeVO") NoticeVO noticeVO,
//                               @RequestParam("userId") Long userId, HttpServletRequest request){
//        noticeVO.setNoticeId(noticeService.getNoticeSeqNext()) ;
//        noticeService.insertNotice(noticeVO);
//        noticeVO.setUserId(noticeService.getUserId);
//        return "redirect:/community/notification";
////     ☆★☆★   더미데이터 값 delete하고 다시 확인해보기 ☆★☆★☆★☆★
//    }
    @PostMapping("/notification/notification-detail")
    public String insertNotice (@ModelAttribute("noticeVO") NoticeVO noticeVO, HttpServletRequest request, Model
            model){
        // 현재 사용자의 userId를 세션에서 가져오기
        Long userId = (Long) request.getSession().getAttribute("userId");

        if (userId == null) {
            // userId가 없으면 에러 처리 또는 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        // noticeVO에 userId 설정
        noticeVO.setUserId(userId);
        System.out.println(noticeVO);
        // noticeId 설정 및 공지사항 등록
        noticeVO.setNoticeId(noticeService.getNoticeSeqNext());


        // 현재 시간을 LocalDateTime 형식으로 가져오기
        LocalDateTime currentDateTime = LocalDateTime.now();
        // noticeCreatedDate 필드에 현재 시간 할당
        noticeVO.setNoticeCreatedDate(currentDateTime);

        //최종으로 insert시키기
        noticeService.insertNotice(noticeVO);

        return "redirect:/community/notification";
    }

}


