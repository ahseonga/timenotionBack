package com.example.geungeunhanjan.service.lifes;


import com.example.geungeunhanjan.domain.dto.file.FollowDTO;
import com.example.geungeunhanjan.domain.vo.file.UserFileVO;
import com.example.geungeunhanjan.domain.vo.lifes.FollowVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FollowService {

    //팔로우의 다음 시퀀스
    Long getFollowSeqNext();
    //    팔로워 리스트 조회하기
    List<FollowDTO> selectFollower();
    //    팔로잉 리스트 조회하기
    List<FollowDTO> selectFollowing();
    //    팔로우 팔로워 의 이미지소스 파일 조회하기
    List<UserFileVO> selectFile();
    // 팔로우 팔로워의 일기 수 조회하기
    List<FollowDTO> selectBoardCount();
    //팔로우 리스트 유저 클릭시 ; 팔로우 추가하기
    void insertFollow(FollowVO followVO);
}
