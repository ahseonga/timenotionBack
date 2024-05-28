package com.example.geungeunhanjan.service;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BoardService {

    // Board 리스트

    //게시글 등록하기
    int insertBoard(BoardVO boardVO);

    //특정 회원의 게시글 보기(마이페이지)
    List<BoardVO> selectBoard(Long userId);

    // 메인 4칸짜리 게시물
    List<BoardVO> mainBoardbyViews();
}
