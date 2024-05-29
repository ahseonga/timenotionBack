package com.example.geungeunhanjan.domain.vo.board;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LikeVO {
    private Long likeId;
    private Long boardId;
    private Long userId;
}
