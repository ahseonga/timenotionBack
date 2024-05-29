package com.example.geungeunhanjan.domain.dto.board;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class LikeDTO {
    private String boardTitle;
    private LocalDateTime likeCreatedDate;
    private String boardWriter;
    private Long likeClickUser;
}
