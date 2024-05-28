package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.dto.InquiryDTO;
import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.domain.vo.UserVO;
import com.example.geungeunhanjan.service.BoardService;
import com.example.geungeunhanjan.service.InquiryService;
import com.example.geungeunhanjan.service.UserService;
import jakarta.servlet.http.HttpSession;
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
<<<<<<< HEAD
    private final UserService userService;
    private final InquiryService inquiryService;
//    private final HttpSession session;

    public HomeController(BoardService boardService, UserService userService, InquiryService inquiryService) {
        this.boardService = boardService;
        this.userService = userService;
//        this.session = session.getAttribute("userId");
        this.inquiryService = inquiryService;
=======
    private final UserVO userVO;

    public HomeController(BoardService boardService, UserVO userVO) {
        this.boardService = boardService;
        this.userVO = userVO;
>>>>>>> 5c64ec62254cd6bc9193a1322db818dc1f6a545a
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
<<<<<<< HEAD
    public String mypage(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        List<BoardVO> boards = boardService.selectBoard(userId);
=======
    public String mypage(Model model){
//        List<BoardVO> boards = boardService.selectBoard(userVO.getUserId());
        List<BoardVO> boards = boardService.selectBoard(1L);
>>>>>>> 5c64ec62254cd6bc9193a1322db818dc1f6a545a
        model.addAttribute("boards", boards);
        return "myLife/mypage";
    }
<<<<<<< HEAD

    @GetMapping("/detail_writingMode")
    public String detailWritingMode(HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        return "myLife/detail_writingMode";
    }

    @GetMapping("/detail-my")
    public String detailMy(HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
=======
//    게시글 작성페이지로 들어가기
    @GetMapping("/mypage/detail_writingMode")
    public String detailWritingMode(Model model){
        model.addAttribute("boardVO",new BoardVO());
        return "myLife/detail_writingMode";
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
>>>>>>> 5c64ec62254cd6bc9193a1322db818dc1f6a545a
        return "myLife/detail-my";
    }

    @GetMapping("/yourLife")
    public String yourLife(HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
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

    @GetMapping("/inquiry")
    public String community(Model model) {

        List<InquiryDTO> inquiries = inquiryService.selectInquiryAll();

        if (inquiries.size() > 7) {
            inquiries = inquiries.subList(0, 7);
        }

        model.addAttribute("inquiries", inquiries);


        return "community/inquiry";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // 세션 무효화
        return "redirect:/main";
    }
}