package com.example.geungeunhanjan.mapper;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {

    // 보드 리스트

    //게시글 등록하기
    int insertBoard(BoardVO boardVO);

    //특정 회원의 생일 불러오기
    String selectUserBirth(Long userId);

    //특정 회원의 게시글 보기(마이페이지)

    List<BoardVO> selectBoard(Long userId);

    // 메인 4칸짜리 게시물
    List<BoardVO> mainBoardbyViews();
}


