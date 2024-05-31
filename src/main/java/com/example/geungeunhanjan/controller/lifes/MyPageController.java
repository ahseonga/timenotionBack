package com.example.geungeunhanjan.controller.lifes;


import com.example.geungeunhanjan.domain.dto.board.CommentDTO;
import com.example.geungeunhanjan.domain.dto.board.LikeDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Page;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.file.FileVO;
import com.example.geungeunhanjan.service.MyPageService;
import com.example.geungeunhanjan.service.board.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

// myLife로 가는 컨트롤러
@Controller
@RequestMapping("/myLife")
@AllArgsConstructor
public class MyPageController {

    private final BoardService boardService;
    private final MyPageService myPageService;



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

        model.addAttribute("comments", comments);
        model.addAttribute("page", page);

        return "myLife/myPageCommentList";
    }
    // 내가 쓴 댓글로 ㅎㅎㅎㅎ ☆★☆★☆★☆★☆★☆☆★ 작업중 ★☆★☆★☆★☆★☆★☆★☆★
    // 좋아요 목록으로
    @GetMapping("/mypageLike")
    public String mypageLike(Model model, HttpSession session, Criteria criteria){
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        List<LikeDTO> likes = myPageService.findPageMyLike(criteria, userId);
        int total = myPageService.myLikeTotal(userId);
        Page page = new Page(criteria, total);
        model.addAttribute("likes", likes);
        model.addAttribute("page", page);

        return "/myLife/myPageLike";
    }
    // ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
    // 회원정보 수정으로
    @GetMapping("/mypageEditMemberInformation")
    public String mypageEditMemberInformation(HttpSession session){
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        return "/myLife/myPageEditMemberInformation";
    }

    // 회원정보 수정으로 Post
    @PostMapping("/mypageEditMemberInformation")
    public String mypageEditMemberInformation(FileVO fileVO, RedirectAttributes redirectAttributes, HttpSession session,
                                              @RequestParam("File") List<MultipartFile> file){
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        fileVO.setUserId(userId);

        try {
            myPageService.registProfileBackFile(fileVO, file);
        }catch (IOException e){ e.printStackTrace();}


       redirectAttributes.addFlashAttribute("userId", fileVO.getUserId());

        return "redirect:/myLife/myPageEditMemberInformation";
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

