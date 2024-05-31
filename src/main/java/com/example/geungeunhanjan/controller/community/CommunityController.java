package com.example.geungeunhanjan.controller.community;


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
public class CommunityController {
    private final InquiryService inquiryService;
    private final NoticeService noticeService;
    private final NoticeMapper noticeMapper;

<<<<<<< HEAD


    public CommunityController(InquiryService inquiryService, NoticeService noticeService) {
=======
    //의존성 주입
    public CommunityController(InquiryService inquiryService, NoticeService noticeService, NoticeMapper noticeMapper) {
>>>>>>> 19fb4ec5d3745354d6b194235c5c5c6eda8b4203
        this.inquiryService = inquiryService;
        this.noticeService = noticeService;
        this.noticeMapper = noticeMapper;
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

    @PostMapping("/inquiry")
    public String community() {
        return "community/inquiry";
    }



    // ※＠※＠※＠※＠※＠※   공지   ※＠※＠※＠※＠※＠※＠※＠
    //공지버튼 클릭시
    @GetMapping("/notification")
    public String notification(Model model , NoticeCriteria noticeCriteria , HttpServletRequest request) {

        //로그인 한 유저의 userId 를 같이 보냄
        //userId = 1인 회원만 작성 삭제 가능
        Long loggedInUserId = (Long) request.getSession().getAttribute("userId");
        model.addAttribute("loggedInUserId", loggedInUserId);

        //공지 리스트 정보 가져오기
//        List<NoticeDTO> notices = noticeService.selectNoticeAll();
//        model.addAttribute("notices", notices);

        // 페이지 처리
        List<NoticePageDTO> noticeLists = noticeService.selectAllPageNotice(noticeCriteria);
        System.out.println("noticeLists" + noticeLists);
        int total = noticeService.selectTotalNotice();
        System.out.println("total :"+ total);
        NoticePage noticePage = new NoticePage(noticeCriteria, total);
        System.out.println(noticePage);



        //페이징 정보 가져오기
        model.addAttribute("noticeLists",noticeLists);
        model.addAttribute("page", noticePage);



        return "community/notification";
    }

    //공지 삭제시
    @PostMapping("/notification/{noticeId}")
    public String notification(@PathVariable("noticeId") long noticeId) {
//        System.out.println(noticeId);
        noticeService.deleteNotice(noticeId);
        return "redirect:/community/notification";
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

    @GetMapping("/notification/notification-detail")
    public String notificationDetail() {
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
public String insertNotice(@ModelAttribute("noticeVO") NoticeVO noticeVO, HttpServletRequest request,Model model) {
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
>>>>>>> 19fb4ec5d3745354d6b194235c5c5c6eda8b4203
}


