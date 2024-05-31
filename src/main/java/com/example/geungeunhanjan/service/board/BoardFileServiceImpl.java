package com.example.geungeunhanjan.service.board;

import com.example.geungeunhanjan.domain.vo.file.BoardFileVO;
import com.example.geungeunhanjan.mapper.board.BoardFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardFileServiceImpl implements  BoardFileService{

    private final BoardFileMapper boardFileMapper;

    //게시글에 파일 넣기
    @Override
    public void registerFile(BoardFileVO boardFileVO) {
        boardFileMapper.insertFile(boardFileVO);


    }
}
