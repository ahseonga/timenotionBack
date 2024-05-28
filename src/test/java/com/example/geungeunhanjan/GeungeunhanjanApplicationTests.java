package com.example.geungeunhanjan;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import com.example.geungeunhanjan.domain.vo.UserVO;
import com.example.geungeunhanjan.service.BoardService;
import com.example.geungeunhanjan.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class GeungeunhanjanApplicationTests {

    @Autowired
    private BoardService boardService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserVO userVO;
    LocalDateTime dateTime;

    @Test
    void contextLoads() {
    }
    @Test
    void selectBoardTest() {
        List<BoardVO> boards = boardService.selectBoard(1L);
        System.out.println(boards);
    }

    @Test
    void mainBoardTest(){
        List<BoardVO> boards = boardService.mainBoardbyViews();
        System.out.println(boards);
    }

    @Test
    void userNickTest(){
        String nickname = userService.mainBoardByViewsNickname(1L);
        System.out.println(nickname);
    }

    @Test
    void loginTest(){
        long result = userService.userLogin("user1@example.com", "password1");
        System.out.println(result);
    }

    @Test
    void joinTest(){
        userVO.setUserId(51L);
        userVO.setUserName("as");
        userVO.setUserPassword("1234");
        userVO.setUserEmail("ab@ab.com");
        userVO.setUserNickname("as");
        userVO.setUserBirth(dateTime);

        userService.userJoin(userVO);


    }
}
