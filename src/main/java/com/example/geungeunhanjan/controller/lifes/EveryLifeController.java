package com.example.geungeunhanjan.controller.lifes;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Page;
import com.example.geungeunhanjan.domain.dto.user.UserDTO;
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
    private final UserService userService;
    private final UserVO userVO;
    private final BoardDTO boardDTO;

    @GetMapping()
    public String everyLife (Model model, HttpSession session, Criteria criteria) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/user/login";
        }

        // 모두의 일대기 게시물 확인
        List<BoardVO> boards = boardService.everyLifeBoardbyViews();
        List<String> userNicknames = new ArrayList<>();
        for (BoardVO boardList : boards) {
            Long boardId = boardList.getBoardId();
            userNicknames.add(userService.mainBoardByViewsNickname(boardId));
        }

        model.addAttribute("boards", boards);
        model.addAttribute("userNicknames", userNicknames);

        //인기순, 게시판 , 조회순 클릭 시 게시판 정렬
//        List<BoardVO> getboards =


        /*페이징 */

//        String boardLifeCycle = boardDTO.getBoardLifeCycle();
//        String cycle = "청소년기";
//        List<BoardDTO> everyLifeList = boardService.everyLifeFindPage(criteria, cycle);
//        int total = boardService.everyLifeFindTotal(boardLifeCycle);
//        Page page = new Page(criteria, total);
//
//        model.addAttribute("everyLifeList", everyLifeList);
//        model.addAttribute("page", page);




        return "everyLife/everyLife";
    }

    @GetMapping("/detail-others")
    public String everyDetailOthers() {
        return "everyLife/detail-others";
    }
}