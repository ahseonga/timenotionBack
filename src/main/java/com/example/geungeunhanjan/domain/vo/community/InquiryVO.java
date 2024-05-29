package com.example.geungeunhanjan.domain.vo.community;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class InquiryVO {
    private Long inquiryId;
    private String inquiryTitle;
    private String inquiryContent;
    private String inquiryResponse;
    private LocalDateTime inquiryCreatedDate;
    private boolean inquiryPublic;
    private String inquiryBannerName;
    private String inquiryBannerSource;
    private Long userId;
}
