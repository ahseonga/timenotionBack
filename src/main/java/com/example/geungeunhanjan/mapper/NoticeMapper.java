package com.example.geungeunhanjan.mapper;

import com.example.geungeunhanjan.domain.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface NoticeMapper {
    //공지 리스트 조회하기
    List<NoticeDTO> selectNoticeAll();
    // 공지 리스트 클릭시 상세 페이지 조회하기
    NoticeDTO selectNoticeDetail(Long noticeId);
}
