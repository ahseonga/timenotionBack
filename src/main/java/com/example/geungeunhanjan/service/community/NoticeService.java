package com.example.geungeunhanjan.service.community;


<<<<<<< HEAD:src/main/java/com/example/geungeunhanjan/service/NoticeService.java
import com.example.geungeunhanjan.domain.dto.NoticeDTO;
import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.domain.vo.NoticeVO;
=======
import com.example.geungeunhanjan.domain.dto.community.NoticeDTO;
>>>>>>> 8726178c37a347f042d657a15bd3fbed9e2c27e6:src/main/java/com/example/geungeunhanjan/service/community/NoticeService.java
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoticeService {
    //문의의 다음 시퀀스
    Long getNoticeSeqNext();

    //공지 리스트 조회하기
    List<NoticeDTO> selectNoticeAll();

    // 공지 리스트 클릭시 상세 페이지 조회하기
    NoticeDTO selectNoticeDetail(Long noticeId);

    //공지 작성하기
    void insertNotice(NoticeVO noticeVO);
}
