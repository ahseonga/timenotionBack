package com.example.geungeunhanjan.api;

import com.example.geungeunhanjan.domain.dto.board.CommentDTO;
import com.example.geungeunhanjan.domain.dto.comment.CommentWriteDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Slice;
import com.example.geungeunhanjan.service.comment.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentApi {
    private final CommentService commentService;
    /* 여기 댓글 서비스 넣어야함 */

    // 1. 댓글 작성
    @PostMapping("/v1/boards/{boardId}/reply")
    public void commentWrite(@RequestBody CommentWriteDTO commentWriteDTO,
                             @PathVariable("boardId") Long boardId,
                             HttpServletRequest request){
        /* 요청 본문에서 ReplyWriteDTO 받아오고, url 경로에서 boardId를 추출하여 boardId 파라미터에 바인딩
        *  세션에서 userId 받아줌 */
        Long userId = (Long) request.getSession().getAttribute("userId");
        System.out.println(userId);
        commentWriteDTO.setBoardId(boardId);
        commentWriteDTO.setUserId(userId);
        System.out.println("boardID : " + boardId + " userId : " + userId);
        commentService.registComment(commentWriteDTO);
    }
    // 2. 댓글 목록 뿌리기
    @GetMapping("/v1/boards/{boardId}/replies")
    public List<CommentDTO> commentList(){
        List<CommentDTO> commentDTOList = new ArrayList<>();
        return commentDTOList;
    }
    // 3. Slice
    @GetMapping("/v2/boards/{boardId}/replies")
    public Slice<CommentDTO> commentListSlice(@PathVariable("boardId") int boardId){
        Slice<CommentDTO> slice = new Slice<>();
        return slice;
    }
    // 4. 댓글 수정
    /* @PatchMapping()*/
    // 5. 댓글 삭제
    /* @DeleteMapping()*/


}
