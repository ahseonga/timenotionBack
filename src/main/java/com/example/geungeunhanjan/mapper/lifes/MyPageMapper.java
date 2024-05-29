package com.example.geungeunhanjan.mapper.lifes;

import com.example.geungeunhanjan.domain.dto.CommentDTO;
import com.example.geungeunhanjan.domain.dto.LikeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyPageMapper {
    // 1. 좋아요 목록 select
    List<LikeDTO>selectMyLike(Long userId);
    // 2. 내가 쓴 댓글 목록 select
    List<CommentDTO> selectMyComment(Long userId);
}
