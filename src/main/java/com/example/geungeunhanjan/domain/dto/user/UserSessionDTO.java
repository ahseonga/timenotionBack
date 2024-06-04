package com.example.geungeunhanjan.domain.dto.user;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserSessionDTO {
    private Long userId;
    private Long kakaoUserId;
    private Long uniId;
    private String userNickname;
}
