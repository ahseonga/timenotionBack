package com.example.geungeunhanjan.service.community;

<<<<<<< HEAD:src/main/java/com/example/geungeunhanjan/service/NoticeServiceImpe.java
import com.example.geungeunhanjan.domain.dto.NoticeDTO;
import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.domain.vo.NoticeVO;
import com.example.geungeunhanjan.mapper.NoticeMapper;
=======
import com.example.geungeunhanjan.domain.dto.community.NoticeDTO;
import com.example.geungeunhanjan.mapper.community.NoticeMapper;
>>>>>>> 8726178c37a347f042d657a15bd3fbed9e2c27e6:src/main/java/com/example/geungeunhanjan/service/community/NoticeServiceImpe.java

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpe implements NoticeService {

    //의존성주입
    private final NoticeMapper noticeMapper;

    public NoticeServiceImpe(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }


    //문의 다음 시퀀스
    @Override
    public Long getNoticeSeqNext() {
        return  noticeMapper.getNoticeSeqNext();
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
    //공지글 작성하기
    @Override
    public void insertNotice(NoticeVO noticeVO) {
    }



}
