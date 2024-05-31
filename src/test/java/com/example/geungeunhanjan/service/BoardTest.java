package com.example.geungeunhanjan.service;

import com.example.geungeunhanjan.service.board.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void test() {
        System.out.println(boardService.selectBoard(1L));;
    }

}
