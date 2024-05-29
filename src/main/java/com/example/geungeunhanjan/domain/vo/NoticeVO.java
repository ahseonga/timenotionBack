package com.example.geungeunhanjan.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class NoticeVO {
    private Long noticeId;
    private String noticeTitle;
    private String noticeContent;
    private LocalDateTime noticeCreatedDate;
//    private String noticeBannerName;
//    private String noticeBannerSource;
    private Long userId;
}
