package com.example.geungeunhanjan.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//최신순, 인기순, 조회순 게시판(정렬)
@Component
@Data
public class ViewDTO {
    private String userNickname;
    private String boardTitle;
    private LocalDateTime boardCreatedDate; // 최신순
    private int boardLikeCount; // 인기순
    private int board_view_count; //조회순
}
