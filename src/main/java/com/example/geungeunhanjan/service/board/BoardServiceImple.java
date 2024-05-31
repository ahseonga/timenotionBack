package com.example.geungeunhanjan.service.board;

import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.mapper.board.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BoardServiceImple implements BoardService {

    private final BoardMapper boardMapper;

    public BoardServiceImple(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    //게시글 등록하기
    @Override
    public int insertBoard(BoardVO boardVO) {
//        boardVO.setBoardId(boardVO.getBoardId());
        int cnt = boardMapper.insertBoard(boardVO);
        return cnt;
    }
    //특정 회원의 생일 불러오기
    @Override
    public String selectUserBirth(Long userId) {
        return boardMapper.selectUserBirth(userId);
    }

    // 게시글 등록과 생일 조회 및 라이프 사이클 계산을 동시에 처리
//    @Transactional
//    public int createBoard(BoardVO boardVO) {
//        String userBirthStr = selectUserBirth(boardVO.getUserId());
//        Date userBirth = parseDate(userBirthStr);
//
//        int boardYear = boardVO.getBoardYear();
//        int birthYear = getYearFromDate(userBirth);
//        int age = boardYear - birthYear;
//
//        String lifeCycle = calculateLifeCycle(age);
//        boardVO.setBoardLifeCycle(lifeCycle);
//
//        return insertBoard(boardVO);
//    }
//
//    private Date parseDate(String dateStr) {
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            return sdf.parse(dateStr);
//        } catch (Exception e) {
//            throw new RuntimeException("Error parsing date", e);
//        }
//    }
//
//    private int getYearFromDate(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        return calendar.get(Calendar.YEAR);
//    }
//
//    private String calculateLifeCycle(int age) {
//        if (age >= 0 && age <= 5) {
//            return "유아";
//        } else if (age >= 6 && age <= 10) {
//            return "유년기";
//        } else if (age >= 11 && age <= 17) {
//            return "청소년기";
//        } else if (age >= 18 && age <= 29) {
//            return "청년";
//        } else if (age >= 30 && age <= 49) {
//            return "중년";
//        } else if (age >= 50 && age <= 64) {
//            return "노년";
//        } else {
//            return "전성기";
//        }
//    }

    // Board의 리스트
    //특정 회원의 게시글 보기(마이페이지)
    @Override
    public List<BoardVO> selectBoard(Long userId) {
        return boardMapper.selectBoard(userId);
    }

    // 그 main 4칸 짜리 게시물
    @Override
    public List<BoardVO> mainBoardbyViews() {
        return boardMapper.mainBoardbyViews();
    }

    // 모두의 일대기 게시물
    @Override
    public List<BoardVO> everyLifeBoardbyViews() {
        return boardMapper.everyLifeBoardbyViews();
    }




}
