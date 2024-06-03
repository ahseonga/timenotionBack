package com.example.geungeunhanjan.controller.lifes;


import com.example.geungeunhanjan.domain.dto.board.CommentDTO;
import com.example.geungeunhanjan.domain.dto.board.LifeUserInfoDTO;
import com.example.geungeunhanjan.domain.dto.board.LifeUserUpdateDTO;
import com.example.geungeunhanjan.domain.dto.board.LikeDTO;
import com.example.geungeunhanjan.domain.dto.file.FollowDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Page;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.file.UserFileVO;
import com.example.geungeunhanjan.service.MyPageService;
import com.example.geungeunhanjan.service.board.BoardService;
import com.example.geungeunhanjan.service.lifes.FollowService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;

// myLife로 가는 컨트롤러
@Controller
@RequestMapping("/myLife")
@AllArgsConstructor
public class MyPageController {

    private final BoardService boardService;
    private final MyPageService myPageService;
    private final LifeUserUpdateDTO lifeUserUpdateDTO;
    private final FollowService followService;
    private final LifeUserInfoDTO lifeUserInfoDTO;

    // 마이페이지에서 내가 쓴 게시글 리스트 뽑기
    @GetMapping
    public String mypage(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/user/login";
        }
        // 팔로우 : 이거 아직 html에 추가 안 함
//        FollowDTO follow = followService.selectFollowDetail(userId);
//        model.addAttribute("follow", follow);
        // 유저 정보 모두
        LifeUserInfoDTO userInfo = myPageService.selectAllInfo(userId);
        model.addAttribute("userInfo", userInfo);
        // 게시판 정보
        List<BoardVO> boards = boardService.selectBoard(userId);
        model.addAttribute("boards", boards);
        System.out.println(lifeUserUpdateDTO);
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


    @GetMapping("/mypageCommentList")
    public String mypageCommentList(Model model, HttpSession session, Criteria criteria){
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        /* 페이징 된 댓글 목록 가져옴 */
        List<CommentDTO> comments = myPageService.findPageMyComment(criteria, userId);

        /* 1 ) 전체 댓글 수 가져옴 */
        int total = myPageService.myCommentTotal(userId);
        /* 2 ) page에 criteria랑 전체 댓글 수 전달 */
        Page page = new Page(criteria, total);
        // 회원 정보 모두
        LifeUserInfoDTO userInfo = myPageService.selectAllInfo(userId);
        model.addAttribute("userInfo", userInfo);
        // 댓글 / 페이지
        model.addAttribute("comments", comments);
        model.addAttribute("page", page);

        return "myLife/mypageCommentList";
    }
    // 내가 쓴 댓글로
    // 좋아요 목록으로
    @GetMapping("/mypageLike")
    public String mypageLike(Model model, HttpSession session, Criteria criteria){
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/user/login";
        }

        List<LikeDTO> likes = myPageService.findPageMyLike(criteria, userId);
        int total = myPageService.myLikeTotal(userId);
        Page page = new Page(criteria, total);
        // 팔로우 : 이거 아직 html에 추가 안 함
//        FollowDTO follow = followService.selectFollowDetail(userId);
//        model.addAttribute("follow", follow);
        // 회원 정보 모두
        LifeUserInfoDTO userInfo = myPageService.selectAllInfo(userId);
        model.addAttribute("userInfo", userInfo);
        // 좋아요 / 페이지
        model.addAttribute("likes", likes);
        model.addAttribute("page", page);

        return "/myLife/mypageLike";
    }
    // 회원정보 수정으로
    @GetMapping("/mypageEditMemberInformation")
    public String mypageEditMemberInformation(HttpSession session, Model model,
                                              @SessionAttribute("userId") Long userId){
        // 로그인 여부 확인
//        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        LifeUserInfoDTO userInfo = myPageService.selectAllInfo(userId);
        System.out.println(userId);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("lifeUserUpdateDTO", lifeUserUpdateDTO);
        System.out.println(lifeUserUpdateDTO);
        return "/myLife/mypageEditMemberInformation";
    }


    // 회원정보 수정으로 post
    @PostMapping("/mypageEditMemberInformation")
    public String mypageEditMemberInformation(UserFileVO userFileVO, RedirectAttributes redirectAttributes,
                                              @RequestParam(value = "boardFile", required = false) List<MultipartFile> file,
                                              @SessionAttribute("userId") Long userId,
                                              LifeUserInfoDTO lifeUserInfoDTO){
        // 로그인 여부 확인
//        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        userFileVO.setUserId(userId);
        // files가 null인 경우 빈 리스트로 초기화
        if (file == null) {
            file = Collections.emptyList();
        }
        try {
            myPageService.registProfileBackFile(userFileVO, file);
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "파일 업로드 실패");
            return "redirect:/myLife/mypageEditMemberInformation"; // 파일 업로드 실패 시 리다이렉트
        }
        lifeUserUpdateDTO.setUserId(userId);
        try {
            myPageService.updateUserInfo(lifeUserInfoDTO);
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "회원 정보 업데이트 실패");
            return "redirect:/myLife/mypageEditMemberInformation"; // 업데이트 실패 시 리다이렉트
        }
        redirectAttributes.addFlashAttribute("userId", userFileVO.getUserId());

        // 폼 제출 후 리다이렉트
        return "redirect:/myLife";
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

