package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.service.BoardService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main")
public class HomeController {

    private final BoardService boardService;

    public HomeController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/main")
    public String main() {
        return "main/main";
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
    public String yourLife(){
        return "yourLife/yourLife";
    }

    @GetMapping("/everyLife")
    public String everyLife(){
        return "everyLife/everyLife";
    }

    @GetMapping("/inquiry")
    public String inquiry(){
        return "community/inquiry";
    }

}