package com.example.geungeunhanjan.comment;

import com.example.geungeunhanjan.domain.dto.comment.CommentListDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Slice;
import com.example.geungeunhanjan.service.comment.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class CommentTest {

    @Autowired
    private CommentService commentService;

    @Test
    void mypageCommentList() {
        // Given
        Criteria criteria = new Criteria(1, 10);
        Long boardId = 1L;

        // When
        Slice<CommentListDTO> slice = commentService.findCommentSlice(criteria, boardId);

        // Then
        assertThat(slice).isNotNull();
        List<CommentListDTO> comments = slice.getContentList();
        assertThat(comments).isNotEmpty();
        System.out.println(comments);
    }
}