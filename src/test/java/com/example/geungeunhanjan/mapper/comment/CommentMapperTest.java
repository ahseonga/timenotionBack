package com.example.geungeunhanjan.mapper.comment;

import com.example.geungeunhanjan.comment.CommentTest;
import com.example.geungeunhanjan.domain.dto.comment.CommentListDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CommentMapperTest {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentListDTO commentListDTO;
    @Test
    void selectCommentSlice() {
        Criteria criteria = new Criteria();
        commentListDTO = new CommentListDTO();
        commentListDTO.setCommentId(5L);
        commentListDTO.setCommentCreatedDate(LocalDateTime.now());
        commentListDTO.setBoardId(1L);
        commentListDTO.setCommentContent("이거 들어갔나요??");
        commentListDTO.setNickname("히히");

        System.out.println("++++++++++++++" + commentListDTO.getCommentContent());
        System.out.println( commentMapper.selectCommentSlice(criteria,1L));
        commentMapper.selectCommentSlice(criteria,1L);


    }
}