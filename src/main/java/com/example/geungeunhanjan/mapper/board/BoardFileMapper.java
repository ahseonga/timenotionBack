package com.example.geungeunhanjan.mapper.board;

import com.example.geungeunhanjan.domain.vo.file.BoardFileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardFileMapper {
    //게시글에 파일 넣기
    void insertFile(BoardFileVO boardFileVO);
}
