package com.example.geungeunhanjan.service.board;

import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.file.BoardFileVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
@Service
public interface BoardService {

    // Board 리스트

    //게시글 등록하기
    void registerBoard(BoardVO boardVO);

    //게시글 파일 같이 등록하기
    void registerBoardwithFile(BoardVO boardVO, List<MultipartFile> files)  throws IOException;

    //파일 저장하기
    BoardFileVO saveFile(MultipartFile files)throws IOException;

    //특정 회원의 생일 불러오기
    LocalDateTime writerUserBirth(Long userId);

    //특정 회원의 게시글 보기(마이페이지)
    List<BoardVO> selectBoard(Long userId);

    //내가 쓴 게시물의 상게페이지 들어가기
    BoardVO selectById(Long boardId);

    // 메인 4칸짜리 게시물
    List<BoardVO> mainBoardbyViews();

    //
}
