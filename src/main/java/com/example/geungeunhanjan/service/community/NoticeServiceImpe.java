package com.example.geungeunhanjan.service.community;

import com.example.geungeunhanjan.domain.dto.community.NoticeDTO;
import com.example.geungeunhanjan.mapper.community.NoticeMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpe implements NoticeService {

    //의존성주입
    private final NoticeMapper noticeMapper;

    public NoticeServiceImpe(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    //공지 리스트 조회하기
    @Override
    public List<NoticeDTO> selectNoticeAll() {
        return noticeMapper.selectNoticeAll();
    }
    // 공지 리스트 클릭시 상세 페이지 조회하기
    @Override
    public NoticeDTO selectNoticeDetail(Long noticeId) {
        return noticeMapper.selectNoticeDetail(noticeId);
    }

}
