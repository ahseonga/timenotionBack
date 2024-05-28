package com.example.geungeunhanjan.mapper;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardVO> selectBoard(Long userId);

}


