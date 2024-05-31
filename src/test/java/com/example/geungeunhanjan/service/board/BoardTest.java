package com.example.geungeunhanjan.service.board;

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

<<<<<<< HEAD:src/test/java/com/example/geungeunhanjan/service/BoardTest.java



=======
    @Test
    public void writerUserBirthTest(){
        System.out.println(boardService.writerUserBirth(1L));
    }
>>>>>>> main:src/test/java/com/example/geungeunhanjan/service/board/BoardTest.java

}
