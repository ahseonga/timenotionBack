package com.example.geungeunhanjan.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class CommentDTO {
    private String commentsContent;
    private LocalDateTime createdDate;
    private String boardTitle;
    private Long userId; // 댓글 작성자 id
}
