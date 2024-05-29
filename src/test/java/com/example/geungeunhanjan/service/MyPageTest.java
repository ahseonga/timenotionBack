package com.example.geungeunhanjan.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyPageTest {
    @Autowired
    private MyPageService myPageService;

    @Test
    public void selectMyCommentTest() {
        System.out.println(myPageService.selectMyComment(1L));
    }
    @Test
    public void selectMyLikeTest() {
        System.out.println(myPageService.selectMyLike(1L));
    }
}
