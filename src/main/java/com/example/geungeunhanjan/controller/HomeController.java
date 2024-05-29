package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.dto.InquiryDTO;

import com.example.geungeunhanjan.domain.dto.FollowDTO;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.domain.vo.UserVO;
import com.example.geungeunhanjan.domain.vo.FileVO;

import com.example.geungeunhanjan.service.BoardService;

import com.example.geungeunhanjan.service.InquiryService;
import com.example.geungeunhanjan.service.UserService;
import jakarta.servlet.http.HttpSession;

import com.example.geungeunhanjan.service.FollowService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class HomeController {
    // 여기서 HttpSession 사용해서 로그인 관리 해봤는데
    // 이거 때문에 로그인 해야지 원하는 화면으로 가실 수 있어서
    // 불편하시면 빼고 진행해주시면 감사하겠습니다
    // HttpSession만 빼면 됩니다

    private final BoardService boardService;
    private final UserService userService;
    private final InquiryService inquiryService;
//    private final HttpSession session;
    private final UserVO userVO;
    private final FollowService followService;



    public HomeController(BoardService boardService, UserVO userVO, InquiryService inquiryService, UserService userService,  FollowService followService) {

        this.boardService = boardService;
        this.userService = userService;
        this.inquiryService = inquiryService;
        this.userVO = userVO;
        this.followService = followService;
    }




    @GetMapping
    public String index(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
//        if (userId == null) {
//            return "/main";
//        }

        List<BoardVO> boards = boardService.mainBoardbyViews();
        List<String> userNicknames = new ArrayList<>();
        for (BoardVO boardList : boards) {
            Long boardId = boardList.getBoardId();
            userNicknames.add(userService.mainBoardByViewsNickname(boardId));
        }

        model.addAttribute("boards", boards);
        model.addAttribute("userNicknames", userNicknames);

        return "main/index";
    }

    @GetMapping("/about")
    public String about(HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        return "main/about";
    }

//    마이페이지에서 내가 쓴 게시글 리스트 뽑기
    @GetMapping("/mypage")
    public String mypage(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        return "myLife/mypage";
    }


    @GetMapping("/mypage/detail_writingMode")
    public String detailMy(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        model.addAttribute("boardVO",new BoardVO());
        return "myLife/detail_writingMode";
//    게시글 작성페이지로 들어가기
    }

//    작성한 게시글 db저장
    @PostMapping("/mypage/detail_writingMode")
    public String detailWriting(@ModelAttribute("boardVO") BoardVO boardVO,
                                @RequestParam("userId") Long userId){
        boardVO.setUserId(userId);
        boardService.insertBoard(boardVO);
        return "redirect:/myLife/mypage";
    }

    @GetMapping("/mypage/detail-my")
    public String detailMy(){
        return "myLife/detail-my";
    }

    @GetMapping("/yourLife")
    public String yourLife(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }


        List<FollowDTO> followers = followService.selectFollower();
        model.addAttribute("followers", followers);

        List<FollowDTO> followings = followService.selectFollowing();
        model.addAttribute("followings", followings);

        List<FileVO> files = followService.selectFile();
        model.addAttribute("files", files);

        List<FollowDTO> boards = followService.selectBoardCount();
        model.addAttribute("boards", boards);


        return "yourLife/yourLife";
    }

    @GetMapping("/everyLife")
    public String everyLife(HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        return "everyLife/everyLife";
    }

//    @GetMapping("/inquiry")
//    public String inquiry() {
//        return "community/inquiry";
//    }






    @GetMapping("/inquiry")

    public String community(Model model) {

        List<InquiryDTO> inquiries = inquiryService.selectInquiryAll();

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



    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // 세션 무효화
        return "redirect:/main";
    }
}