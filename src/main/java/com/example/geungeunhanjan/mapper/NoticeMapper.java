package com.example.geungeunhanjan.mapper;

import com.example.geungeunhanjan.domain.dto.NoticeDTO;
import com.example.geungeunhanjan.domain.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface NoticeMapper {
    //문의의 다음 시퀀스
    Long getNoticeSeqNext();

    // 공지 리스트 클릭시 상세 페이지 조회하기
    NoticeDTO selectNoticeDetail(Long noticeId);

    //공지 리스트 조회하기
    List<NoticeDTO> selectNoticeAll();

    //공지 작성하기
    void insertNotice(NoticeVO noticeVO);
}
