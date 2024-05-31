package com.example.geungeunhanjan.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class KakaoVO {
    private Long kakaoUserId;
    private String kakaoUserEmail;
    private String kakaoPassword;
    private String kakaoUserNickname;
    private LocalDateTime kakaoUserBirth;
    private Long userId;
}
