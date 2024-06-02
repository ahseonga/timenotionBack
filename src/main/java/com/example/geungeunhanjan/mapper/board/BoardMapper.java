package com.example.geungeunhanjan.mapper.board;

import com.example.geungeunhanjan.domain.dto.board.BoardMainDTO;
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
    List<BoardMainDTO> mainBoardbyViews();

    // 메인 배너 왼쪽거
    BoardMainDTO mainLeftBannerSelect();

    // 메인 배너 오른쪽거 2개
    List<BoardMainDTO> mainRightBannerSelect();
}


