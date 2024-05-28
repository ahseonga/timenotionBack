package com.example.geungeunhanjan;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.mapper.BoardMapper;
import com.example.geungeunhanjan.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GeungeunhanjanApplicationTests {

    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardMapper boardMapper;
    @Test
    void contextLoads() {
    }
    @Test
    void selectBoardTest() {
        List<BoardVO> boards = boardService.selectBoard(1L);
        System.out.println(boards);
    }

    @Test
    public void insertBoardTest(BoardVO boardVO) {
        Long boardId = boardMapper.getSeq();
        boardVO.setBoardId(boardId);
        boardMapper.insertBoard(boardVO);
        System.out.println(boardVO);
    }


}
