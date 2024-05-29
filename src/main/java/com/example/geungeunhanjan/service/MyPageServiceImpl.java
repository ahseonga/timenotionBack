package com.example.geungeunhanjan.service;

import com.example.geungeunhanjan.domain.dto.CommentDTO;
import com.example.geungeunhanjan.domain.dto.LikeDTO;
import com.example.geungeunhanjan.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements  MyPageService{
    // 마이페이지
    private final MyPageMapper myPageMapper;

    @Override
    public List<LikeDTO> selectMyLike(Long userId) {
        return myPageMapper.selectMyLike(userId);
    }

    //2. 내가 쓴 댓글 select
    @Override
    public List<CommentDTO> selectMyComment(Long userId) {
        return myPageMapper.selectMyComment(userId);
    }






}
