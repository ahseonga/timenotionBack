package com.example.geungeunhanjan.controller.lifes;

import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.user.UserVO;
import com.example.geungeunhanjan.service.board.BoardService;
import com.example.geungeunhanjan.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

// 모두의 일대기로
@Controller
@RequestMapping("/everyLife")
@AllArgsConstructor
public class EveryLifeController {

    private final BoardService boardService;
    private  final UserService userService;
    private final UserVO userVO;


    @GetMapping()
    public String everyLife(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/user/login";
        }
        List<BoardVO> boards = boardService.everyLifeBoardbyViews();
        List<String> userNicknames = new ArrayList<>();
        for (BoardVO boardList : boards) {
            Long boardId = boardList.getBoardId();
            userNicknames.add(userService.mainBoardByViewsNickname(boardId));
        }

        model.addAttribute("boards", boards);
        model.addAttribute("userNicknames", userNicknames);

        return "everyLife/everyLife";
    }

    @GetMapping("/detail-others")

    public String everyDetailOthers() {
        return "everyLife/detail-others";
    }



}
