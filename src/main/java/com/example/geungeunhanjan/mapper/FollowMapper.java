package com.example.geungeunhanjan.mapper;


import com.example.geungeunhanjan.domain.dto.FollowDTO;
import com.example.geungeunhanjan.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowMapper {
//    팔로워 리스트 조회하기
    List<FollowDTO> selectFollower();

//    팔로잉 리스트 조회하기
    List<FollowDTO> selectFollowing();

//    팔로우 팔로워 의 이미지소스 파일 조회하기
    List<FileVO> selectFile();

    // 팔로우 팔로워의 일기 수 조회하기
    List<FollowDTO> selectBoardCount();
}
