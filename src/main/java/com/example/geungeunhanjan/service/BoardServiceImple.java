package com.example.geungeunhanjan.service;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImple implements BoardService {

    private final BoardMapper boardMapper;

    public BoardServiceImple(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    //게시글 등록하기
    @Override
    public int insertBoard(BoardVO boardVO) {
//        boardVO.setBoardId(boardVO.getBoardId());
        int cnt = boardMapper.insertBoard(boardVO);
        return cnt;
    }

<<<<<<< HEAD
    // Board의 리스트
=======
    //특정 회원의 게시글 보기(마이페이지)
>>>>>>> 5c64ec62254cd6bc9193a1322db818dc1f6a545a
    @Override
    public List<BoardVO> selectBoard(Long userId) {
        return boardMapper.selectBoard(userId);
    }

    // 그 main 4칸 짜리 게시물
    @Override
    public List<BoardVO> mainBoardbyViews() {
        return boardMapper.mainBoardbyViews();
    }
}
