package com.example.geungeunhanjan.controller.lifes;


import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.service.board.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

// myLife로 가는 컨트롤러
@Controller
@RequestMapping("/myLife")
@AllArgsConstructor
public class MyPageController {

    private final BoardService boardService;

    // 마이페이지에서 내가 쓴 게시글 리스트 뽑기
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
    //나의 일대기 글쓰기 페이지로 이동
    @GetMapping("/detail_writingMode")
    public String detailWritingMode(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
//        model.addAttribute("boardVO", new BoardVO());
        return "myLife/detail_writingMode";
    }

    //나의 일대기 게시판 작성하기
    @PostMapping("/detail_writingMode")
    public String detailWriting(BoardVO boardVO, @SessionAttribute("userId") Long userId,
                                @RequestParam("boardFile") List<MultipartFile> files,
                                RedirectAttributes redirectAttributes) {

        boardVO.setUserId(userId);

        // 데이터베이스에서 사용자의 생일을 가져옴
        LocalDateTime userBirthDateTime = boardService.writerUserBirth(userId);

        // 사용자의 생일에서 연도를 추출
        int userBirthYear = userBirthDateTime.getYear();

        System.out.println(userBirthYear);

        // 게시물을 작성한 년도
        int boardYear = boardVO.getBoardYear();

        System.out.println(boardYear);

        // 사용자의 나이 계산
        int age = boardYear - userBirthYear;

        System.out.println(age);

        // 사용자의 생년 이전을 입력하면 다시 입력하도록 처리
        if (boardYear < userBirthYear) {
            redirectAttributes.addFlashAttribute("errorMessage", "게시물 작성 년도는 생년보다 이전일 수 없습니다.");
            return "redirect:/myLife/detail_writingMode"; // 사용자가 입력 폼으로 돌아가도록 리다이렉트
        }

        // 사용자의 생애 주기 계산
        String lifeCycle = calculateLifeCycle(age);

        // 게시물의 생애 주기 설정
        boardVO.setBoardLifeCycle(lifeCycle);


        // 게시물 등록
//        boardService.registerBoard(boardVO);

        try {
            boardService.registerBoardwithFile(boardVO, files);
        }catch (IOException e){
            e.printStackTrace();
        }

        redirectAttributes.addFlashAttribute("boardId", boardVO.getBoardId());
        return "redirect:/myLife";
    }


    //글쓰기 상세페이지로 이동
    @GetMapping("/detail-my")
    public String detailMy(Model model, Long boardId){
        BoardVO boards = boardService.selectById(boardId);
        model.addAttribute("boards",boards);
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

    //나이에 따른 LifeCycle 지정해주는 메소드
    // 나이에 따른 LifeCycle 지정해주는 메소드
    private String calculateLifeCycle(int age) {
        if (age >= 65) {
            return "노년기";
        } else if (age >= 35) {
            return "중년기";
        } else if (age >= 20) {
            return "청년기";
        } else if (age >= 13) {
            return "청소년기";
        } else if (age >= 9) {
            return "아동기";
        } else if (age >= 6) {
            return "유년기";
        } else if (age >= 0) {
            return "유아기";
        } else {
            return "유아기 미만";
        }
    }

}

