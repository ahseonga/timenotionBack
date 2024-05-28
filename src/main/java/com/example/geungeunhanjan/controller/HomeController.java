package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.dto.FollowDTO;
import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.domain.vo.UserVO;
import com.example.geungeunhanjan.domain.vo.FileVO;

import com.example.geungeunhanjan.service.BoardService;
import com.example.geungeunhanjan.service.FollowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/main")
public class HomeController {

    private final BoardService boardService;
    private final UserVO userVO;
    private final FollowService followService;

    public HomeController(BoardService boardService, UserVO userVO,  FollowService followService) {
        this.boardService = boardService;
        this.userVO = userVO;
        this.followService = followService;
    }




    @GetMapping
    public String index() {
        return "main/index";
    }

    @GetMapping("/about")
    public String about(){
        return "main/about";
    }

//    마이페이지에서 내가 쓴 게시글 리스트 뽑기
    @GetMapping("/mypage")
    public String mypage(Model model){
//        List<BoardVO> boards = boardService.selectBoard(userVO.getUserId());
        List<BoardVO> boards = boardService.selectBoard(1L);
        model.addAttribute("boards", boards);
        return "myLife/mypage";
    }
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
        return "myLife/detail-my";
    }

    @GetMapping("/yourLife")
    public String yourLife(Model model){

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
    public String everyLife(){
        return "everyLife/everyLife";
    }

//    @GetMapping("/inquiry")
//    public String inquiry() {
//        return "community/inquiry";
//    }





}