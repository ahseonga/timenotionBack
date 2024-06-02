package com.example.geungeunhanjan.mapper.board;


import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.board.BoardMainDTO;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {

    //게시글 등록하기
    void insertBoard(BoardVO boardVO);

    //특정 회원의 생일 불러오기
    LocalDateTime selectUserBirth(Long userId);

    //특정 회원의 게시글 보기(마이페이지)
    List<BoardVO> selectBoard(Long userId);

    //내가쓴 특정게시물 상세페이지 들어가기
    Optional<BoardVO> selectById(Long boardId);

    // 메인 4칸짜리 게시물
//    List<BoardVO> mainBoardbyViews();

    // 모두의 일대기 게시물
    List<BoardVO> everyLifeBoardbyViews();

    // 모두의 일대기 리스트 + 페이징
    List<BoardDTO> everyLifeagepaging(@Param("criteria") Criteria criteria, @Param("boardLifeCycle")String boardLifeCycle);

    // 유아기, 유년기, 아동기, 청소년기, 성인, 중년, 노년 클릭시 페이지 이동
    int agePageMove(String boardLifeCycle);

//     최신순, 인기순 , 좋아요 순 게시판 정렬
    // 1) 조회수 게시판 정렬
    List<BoardVO> postarrayviews();

    // 2) 최신순 게시판 정렬
    List<BoardVO> postarrayLatest();

    // 3) 인기순 게시판 정렬
    List<BoardVO> postarrayPopularity();


    List<BoardMainDTO> mainBoardbyViews();

    // 메인 배너 왼쪽거
    BoardMainDTO mainLeftBannerSelect();

    // 메인 배너 오른쪽거 2개
    List<BoardMainDTO> mainRightBannerSelect();

}


