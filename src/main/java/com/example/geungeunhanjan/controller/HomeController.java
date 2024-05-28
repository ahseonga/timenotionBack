package com.example.geungeunhanjan.controller;

<<<<<<< HEAD
import com.example.geungeunhanjan.domain.dto.InquiryDTO;
=======
import com.example.geungeunhanjan.domain.dto.FollowDTO;
>>>>>>> 7bc2f127f563150cc982edd7850fb3ad34eb85b5
import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.domain.vo.UserVO;
import com.example.geungeunhanjan.domain.vo.FileVO;

import com.example.geungeunhanjan.service.BoardService;
<<<<<<< HEAD
import com.example.geungeunhanjan.service.InquiryService;
import com.example.geungeunhanjan.service.UserService;
import jakarta.servlet.http.HttpSession;
=======
import com.example.geungeunhanjan.service.FollowService;
>>>>>>> 7bc2f127f563150cc982edd7850fb3ad34eb85b5
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

<<<<<<< HEAD
    public HomeController(BoardService boardService, UserService userService, InquiryService inquiryService, UserVO userVO) {
=======
    public HomeController(BoardService boardService, UserVO userVO,  FollowService followService) {
>>>>>>> 7bc2f127f563150cc982edd7850fb3ad34eb85b5
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
        List<BoardVO> boards = boardService.selectBoard(userId);
        model.addAttribute("boards", boards);

        return "myLife/mypage";
    }


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
<<<<<<< HEAD
    public String yourLife(HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
=======
    public String yourLife(Model model){

        List<FollowDTO> followers = followService.selectFollower();
        model.addAttribute("followers", followers);

        List<FollowDTO> followings = followService.selectFollowing();
        model.addAttribute("followings", followings);

        List<FileVO> files = followService.selectFile();
        model.addAttribute("files", files);

        List<FollowDTO> boards = followService.selectBoardCount();
        model.addAttribute("boards", boards);

>>>>>>> 7bc2f127f563150cc982edd7850fb3ad34eb85b5
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
<<<<<<< HEAD
    public String community(Model model) {

        List<InquiryDTO> inquiries = inquiryService.selectInquiryAll();

        if (inquiries.size() > 7) {
            inquiries = inquiries.subList(0, 7);
        }

        model.addAttribute("inquiries", inquiries);


        return "community/inquiry";
    }
=======
    public String community() {return "community/inquiry";}
>>>>>>> 7bc2f127f563150cc982edd7850fb3ad34eb85b5

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // 세션 무효화
        return "redirect:/main";
    }
}