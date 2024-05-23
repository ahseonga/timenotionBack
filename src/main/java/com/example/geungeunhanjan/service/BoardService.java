package com.example.geungeunhanjan.service;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BoardService {
    List<BoardVO> selectBoard(Long userId);
}
