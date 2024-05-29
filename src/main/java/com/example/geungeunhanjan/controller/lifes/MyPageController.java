package com.example.geungeunhanjan.controller.lifes;


import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.service.board.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// myLife로 가는 컨트롤러
@Controller
@RequestMapping("/myLife")
@AllArgsConstructor
public class MyPageController {

    private final BoardService boardService;



    //    마이페이지에서 내가 쓴 게시글 리스트 뽑기
    @GetMapping
    public String mypage(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/user/login";
        }
        List<BoardVO> boards = boardService.selectBoard(userId);
        model.addAttribute("boards", boards);
        return "myLife/mypage";
    }
    //글쓰기 페이지로 이동
    @GetMapping("/detail_writingMode")
    public String detailMy(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        model.addAttribute("boardVO", new BoardVO());
        return "myLife/detail_writingMode";
    }
    //글쓰기 완료후 코드
    @PostMapping("/detail_writingMode")
    public String detailWriting(BoardVO boardVO){
        int result = boardService.insertBoard(boardVO); // 수정: createBoard 메소드로 변경
        return "redirect:/myLife/mypage";
    }

    //글쓰기 상세페이지로 이동
    @GetMapping("/detail-my")
    public String detailMy(){
        return "myLife/detail-my";
    }

    // 내가 쓴 댓글로

    @GetMapping("/mypageCommentList")
    public String mypageCommentList(){

        return "myLife/myPageCommentList";
    }

    // 좋아요 목록으로
    @GetMapping("/mypageLike")
    public String mypageLike(){

        return "/myLife/myPageLike";
    }

    // 회원정보 수정으로
    @GetMapping("/mypageEditMemberInformation")
    public String mypageEditMemberInformation(){
        return "/myLife/myPageEditMemberInformation";
    }

    // 알림으로
    @GetMapping("/mypageNotification")
    public String mypageNotification(){
        return "/myLife/myPageNotification";
    }

    // 비밀번호 변경으로
    @GetMapping("/mypagePasswordChange")
    public String changepassword(){
        return "/myLife/mypagePasswordChange";
    }
}

