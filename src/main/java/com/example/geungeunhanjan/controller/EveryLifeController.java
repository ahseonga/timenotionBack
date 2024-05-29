package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.service.BoardService;
import com.example.geungeunhanjan.service.EveryLifeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// 모두의 일대기로
@Controller
@RequestMapping("/everyLife")
@AllArgsConstructor
public class EveryLifeController {

    private final BoardService boardService;
    private final EveryLifeService everyLifeService;

    @GetMapping("/detail-others")

    public String everyDetailOthers() {
        return "myLife/detail-others";
    }


    // 검색창 컨트롤러 구현 //
    @GetMapping("/main/everyLife")
    public String searchEveryLife(@RequestParam("searchKeyword") String searchKeyword, Model model) {
        // 검색어를 서비스로 전달하여 검색 결과를 가져옴
        List<BoardVO> boardVOList = everyLifeService.searchByKeyword(searchKeyword);
        // 모델에 검색 결과를 추가하여 뷰로 전달
        model.addAttribute("searchResults", boardVOList); // 수정된 부분
        return "searchResultsView"; // 검색 결과를 보여줄 뷰 이름
    }


}




