package com.example.geungeunhanjan.service;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

// 모두의 일대기 검색창 서비스 구현 //
@Service
public interface EveryLifeService {
    List<BoardVO> searchByKeyword(String keyword);
}
