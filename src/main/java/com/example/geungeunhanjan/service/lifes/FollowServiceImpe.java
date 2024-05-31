package com.example.geungeunhanjan.service.lifes;


import com.example.geungeunhanjan.domain.dto.file.FollowDTO;
import com.example.geungeunhanjan.domain.vo.file.FileVO;
import com.example.geungeunhanjan.domain.vo.lifes.FollowVO;
import com.example.geungeunhanjan.mapper.lifes.FollowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpe implements FollowService {

    //의존성 주입
    private final FollowMapper followMapper;

    public FollowServiceImpe(FollowMapper followMapper) {
        this.followMapper = followMapper;
    }

    @Override
    public Long getFollowSeqNext() {
        return followMapper.getFollowSeqNext();
    }

    //팔로워 리스트 조회하기
    @Override
    public List<FollowDTO> selectFollower() {
        return followMapper.selectFollower();
    }

    //팔로잉 리스트 조회하기
    @Override
    public List<FollowDTO> selectFollowing() {
        return followMapper.selectFollowing();
    }


    //팔로우 팔로워 의 이미지소스 파일 조회하기
    @Override
    public List<FileVO> selectFile() {
        return followMapper.selectFile();
    }

    @Override
    public List<FollowDTO> selectBoardCount() {
        return followMapper.selectBoardCount();
    }

    //팔로우 리스트 유저 클릭시 ; 팔로우 추가하기
    @Override
    public void insertFollow(FollowVO followVO) {
        followMapper.insertFollow(followVO);
    }
}
