package com.example.geungeunhanjan.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ReplyVO {
    private Long replyId;
    private String replyContent;
    private LocalDateTime replyCreatedDate;
    private Long userId;
    private Long commentId;
}
