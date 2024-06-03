package com.example.geungeunhanjan.domain.dto.user;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserSessionDTO {
    private Long uniId;
    private String userNickname;
}
