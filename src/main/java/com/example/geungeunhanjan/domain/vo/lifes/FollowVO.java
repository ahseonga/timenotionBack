package com.example.geungeunhanjan.domain.vo.lifes;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FollowVO {
    private Long followId;
    private int followToUser;
    private int followFromUser;
}
