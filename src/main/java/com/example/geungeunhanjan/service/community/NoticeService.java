package com.example.geungeunhanjan.service.community;


import com.example.geungeunhanjan.domain.dto.community.NoticeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoticeService {
    //공지 리스트 조회하기
    List<NoticeDTO> selectNoticeAll();
    // 공지 리스트 클릭시 상세 페이지 조회하기
    NoticeDTO selectNoticeDetail(Long noticeId);
}
