package com.example.geungeunhanjan.domain.dto.board;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class BoardMainDTO {
    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private String boardPublic;
    private LocalDateTime boardCreatedDate;
    private LocalDateTime boardUpdatedDate;
    private int boardViewCount;
    private String boardLifeCycle;
    private int boardLikeCount;
    private int boardYear;
    private Long userId;
    private String userFileProfileSource;
    private String boardFileSourceName;
    private String userNickname;
    private int boardRank;
}
