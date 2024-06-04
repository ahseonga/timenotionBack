package com.example.geungeunhanjan.controller.lifes;


import com.example.geungeunhanjan.domain.dto.FollowPage.FollowCriteria;
import com.example.geungeunhanjan.domain.dto.FollowPage.FollowPage;
import com.example.geungeunhanjan.domain.dto.file.FollowDTO;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.lifes.FollowVO;
import com.example.geungeunhanjan.domain.vo.user.UniVO;
import com.example.geungeunhanjan.service.board.BoardService;
import com.example.geungeunhanjan.service.lifes.FollowService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/yourLife")
@AllArgsConstructor
public class YourLifeController {

    private final FollowService followService;
    private final BoardService boardService;
    //너의 일대기 클릭시
    @GetMapping()
    public String yourLife(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long uniId = (Long) session.getAttribute("uniId");
        if (uniId == null) {

            return "redirect:/user/login";
        }



        //팔로워 리스트 조회
        List<FollowDTO> followers = followService.selectFollower(uniId);
        model.addAttribute("followers", followers);
        System.out.println(followers);
        //팔로잉 리스트 조회
//        List<FollowDTO> followings = followService.selectFollowing();
//        model.addAttribute("followings", followings);
//        System.out.println(followings);
//        System.out.println(model);
        //팔로우의 일기수 조회
//        List<FollowDTO> boards = followService.selectBoardCount(userId);
//        model.addAttribute("boards", boards);

        //페이지 처리
//        List<FollowDTO> followLists = followService.selectAllPageFollow((followCriteria));
//        int total = followService.selectTotalFollow();
//        FollowPage followPage = new FollowPage(followCriteria,total);
//
//        //페이징 정보 가져오기
//        model.addAttribute("followLists", followLists);
//        model.addAttribute("page", followPage);


        return "yourLife/yourLife";
    }





    //★☆★☆★☆★☆★☆★☆★☆★☆★☆ myLife의 userpage ★☆★☆★☆★☆★☆★☆★☆★☆
    @GetMapping("/userpage/{userId}")
    public String userPage(Model model, @PathVariable("userId") long userId) {

        FollowDTO follow = followService.selectFollowDetail(userId);
        UniVO about = followService.selectFollowAbout(userId);
        List<BoardVO> boards = boardService.selectBoard(userId);
        if(about != null) {
            model.addAttribute("about",about);
        }


        model.addAttribute("boards", boards);
        model.addAttribute("follow", follow);
        System.out.println("dddddddddd");

        return "yourLife/userpage";
    }

    // 유저 페이지 팔로우 기능 구현 컨트롤러 -하트클릭시
    @PostMapping("/userpage/{userId}")
    public String userPage(
            HttpServletRequest request,
            @RequestBody Map<String, Object> requestBody,
            @PathVariable("userId") long userId) {

        // 현재 사용자의 userId를 세션에서 가져오기
        Long loginUserId = (Long) request.getSession().getAttribute("uniId");
        System.out.println(loginUserId);
//        if (loginUserId == null) {
//            // userId가 없으면 에러 처리 또는 로그인 페이지로 리다이렉트
//            return "redirect:/user/login";
//        }

        FollowVO followVO = new FollowVO();

        // followVO에 userId(followToUser) 설정
        followVO.setFollowToUser(loginUserId);
        System.out.println("followToUser 확인용 : " + followVO);

        // followId 설정
        followVO.setFollowId(followService.getFollowSeqNext());
        System.out.println("followToUser 확인용 : " + followVO);

        // followFromUser 설정
        followVO.setFollowFromUser(userId);
        System.out.println("followToUser 확인용 : " + followVO);
        // checkFollow 상태 가져오기
        Boolean checkFollow = (Boolean) requestBody.get("checkFollow");
        System.out.println("checkFollow 상태: " + checkFollow);

        // checkFollow 상태에 따라 필요한 로직을 추가합니다
        if (checkFollow) {
            // 팔로우 로직
            followService.insertFollow(followVO);
        } else {
            // 언팔로우 로직
            followService.deleteFollow(loginUserId);
        }

        System.out.println("followVO 하트클릭테스트: " + followVO);

        return "redirect:/yourLife/userpage/{userId}";
    }





}






