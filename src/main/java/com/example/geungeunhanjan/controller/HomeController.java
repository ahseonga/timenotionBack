package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.dto.FollowDTO;
import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.domain.vo.FileVO;
import com.example.geungeunhanjan.service.BoardService;
import com.example.geungeunhanjan.service.FollowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main")
public class HomeController {

    private final BoardService boardService;
    private final FollowService followService;

    public HomeController(BoardService boardService,  FollowService followService) {
        this.boardService = boardService;
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

    @GetMapping("/mypage")
    public String mypage(Model model){

        List<BoardVO> boards = boardService.selectBoard(1L);
        model.addAttribute("boards", boards);

        return "myLife/mypage";
    }

    @GetMapping("/detail_writingMode")
    public String detailWritingMode(){
        return "myLife/detail_writingMode";
    }

    @GetMapping("/detail-my")
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

    @GetMapping("/inquiry")
    public String community() {return "community/inquiry";}

}