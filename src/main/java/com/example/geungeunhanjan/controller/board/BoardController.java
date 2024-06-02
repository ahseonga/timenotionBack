package com.example.geungeunhanjan.controller.board;

import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    public String mainContentsByViews(){

        return "myLife/detail-others";
    }


}