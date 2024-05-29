package com.example.geungeunhanjan.service;

import com.example.geungeunhanjan.domain.dto.CommentDTO;
import com.example.geungeunhanjan.domain.dto.LikeDTO;

import java.util.List;

public interface MyPageService {
    // 1. 내 좋아요 목록 select
    List<LikeDTO>selectMyLike(Long userId);

    // 2. 내가 쓴 댓글 목록 select
    List<CommentDTO> selectMyComment(Long userId);
}
