package com.example.geungeunhanjan.service;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BoardService {
    // Board 리스트
    List<BoardVO> selectBoard(Long userId);

    // 메인 4칸짜리 게시물
    List<BoardVO> mainBoardbyViews();
}
