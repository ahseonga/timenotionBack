package com.example.geungeunhanjan.service;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.service.EveryLifeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 모두의 일대기 검색창 서비스 구현 Impl//
@Service
public class EveryLifeServiceImpl implements EveryLifeService {

    @Override
    public List<BoardVO> searchByKeyword(String keyword) {
        // 여기에 실제 검색 로직을 구현하고 검색 결과를 반환합니다.
        // 이 예시에서는 단순히 빈 리스트를 반환
        return new ArrayList<>();
    }
}
