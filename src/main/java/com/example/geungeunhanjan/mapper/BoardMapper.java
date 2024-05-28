package com.example.geungeunhanjan.mapper;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 보드 리스트
    List<BoardVO> selectBoard(Long userId);

    // 메인 4칸짜리 게시물
    List<BoardVO> mainBoardbyViews();
}
