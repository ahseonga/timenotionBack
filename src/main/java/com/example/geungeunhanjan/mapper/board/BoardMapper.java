package com.example.geungeunhanjan.mapper.board;

import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import org.apache.ibatis.annotations.Mapper;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {

    //게시글 등록하기
    void insertBoard(BoardVO boardVO);

    //특정 회원의 생일 불러오기
    LocalDateTime selectUserBirth(Long userId);

    //특정 회원의 게시글 보기(마이페이지)
    List<BoardVO> selectBoard(Long userId);

    //내가쓴 특정게시물 상세페이지 들어가기
    Optional<BoardVO> selectById(Long boardId);

    // 메인 4칸짜리 게시물
    List<BoardVO> mainBoardbyViews();

    // 모두의 일대기 게시물
    List<BoardVO> everyLifeBoardbyViews();
}


