package com.example.geungeunhanjan.service.board;

import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.file.BoardFileVO;
import com.example.geungeunhanjan.mapper.board.BoardFileMapper;
import com.example.geungeunhanjan.mapper.board.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final BoardFileMapper boardFileMapper;

    @Value("C:/upload/")
    private String fileDir;


    //나의 일대기 게시글 등록하기
    @Override
    public void registerBoard(BoardVO boardVO) {
//        boardVO.setBoardId(boardVO.getBoardId());
          boardMapper.insertBoard(boardVO);
    }

    @Override
    public void registerBoardwithFile(BoardVO boardVO, List<MultipartFile> files) throws IOException {
        boardMapper.insertBoard(boardVO);
        Long boardId = boardVO.getBoardId();

        for(MultipartFile file: files){
            if(file.isEmpty()){
                break;
            }

           BoardFileVO boardFileVO = saveFile(file);
            boardFileVO.setBoardId(boardId);
            boardFileMapper.insertFile(boardFileVO);
        }
    }

    //파일 저장하기
    @Override
    public BoardFileVO saveFile(MultipartFile files) throws IOException {
        //사용자가 올린 파일이름(확장자를 포함한다)
        String originalFilename = files.getOriginalFilename();
        //파일 이름에 붙여줄 uuid 생성
        UUID uuid = UUID.randomUUID();
        //uuid와 파일이름 합쳐준다
        String systemName = uuid.toString() + "_" + originalFilename;
        //상위 경로와 하위 경로를 합쳐준다
        File uploadPath = new File(fileDir, getUploadPath());

        //경로가 존재하지 않는다면(폴더가 만들어지지 않닸다면)
        if(!uploadPath.exists()){
            //경로에 필요한 모든 폴더를 생성한다
            uploadPath.mkdirs();
        }

        //전체경로와 파일이름을 연결한다
        File uploadFile = new File(uploadPath, systemName);

        //매개변수로 받은 Multipart 객체가 가진 파일을 우리가 만든 경로와 이름으로 저장한다
        files.transferTo(uploadFile);

        BoardFileVO boardFileVO = new BoardFileVO();
        boardFileVO.setBoardFileUuid(uuid.toString());
        boardFileVO.setBoardFileName(originalFilename);
        boardFileVO.setBoardFileSourceName(getUploadPath());

        return boardFileVO;
    }

    private String getUploadPath() {
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    //게시판을 작성한 사람의 생일 불러오기
    @Override
    public LocalDateTime writerUserBirth(Long userId) {
        return boardMapper.selectUserBirth(userId);
    }

    // Board의 리스트
    //특정 회원의 게시글 보기(마이페이지)
    @Override
    public List<BoardVO> selectBoard(Long userId) {
        return boardMapper.selectBoard(userId);
    }

    //내가 쓴 게시물의 상세페이지 들어가기
    @Override
    public BoardVO selectById(Long boardId) {
        return boardMapper.selectById(boardId).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시물 번호"));
    }

    // 그 main 4칸 짜리 게시물
    @Override
    public List<BoardVO> mainBoardbyViews() {
        return boardMapper.mainBoardbyViews();
    }
}
