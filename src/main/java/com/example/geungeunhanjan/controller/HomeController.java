package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.vo.board.BoardVO;

import com.example.geungeunhanjan.domain.vo.user.UserVO;
import com.example.geungeunhanjan.mapper.user.UserMapper;
import com.example.geungeunhanjan.service.board.BoardService;
import com.example.geungeunhanjan.service.community.InquiryService;
import com.example.geungeunhanjan.service.user.UserService;

import jakarta.servlet.http.HttpSession;

import com.example.geungeunhanjan.service.lifes.FollowService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
@AllArgsConstructor
public class HomeController {
    // 여기서 HttpSession 사용해서 로그인 관리 해봤는데
    // 이거 때문에 로그인 해야지 원하는 화면으로 가실 수 있어서
    // 불편하시면 빼고 진행해주시면 감사하겠습니다
    // HttpSession만 빼면 됩니다

    private final BoardService boardService;
    private final UserService userService;
    private final UserMapper userMapper;
    private final InquiryService inquiryService;
    //    private final HttpSession session;
    private final UserVO userVO;
    private final FollowService followService;


    @GetMapping
    public String index(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
//        if (userId == null) {
//            return "/main";


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
            return "redirect:/main/login";
        }
        return "main/about";
    }



}