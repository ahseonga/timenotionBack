package com.example.geungeunhanjan.controller.lifes;


import com.example.geungeunhanjan.domain.dto.file.FollowDTO;
import com.example.geungeunhanjan.domain.vo.community.NoticeVO;
import com.example.geungeunhanjan.domain.vo.file.FileVO;
import com.example.geungeunhanjan.domain.vo.lifes.FollowVO;
import com.example.geungeunhanjan.service.lifes.FollowService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/yourLife")
@AllArgsConstructor
public class YourLifeController {

    private final FollowService followService;

    @GetMapping()
    public String yourLife(Model model, HttpSession session) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/user/login";
        }

        //팔로워 리스트 조회
        List<FollowDTO> followers = followService.selectFollower();
        model.addAttribute("followers", followers);
        //팔로잉 리스트 조회
        List<FollowDTO> followings = followService.selectFollowing();
        model.addAttribute("followings", followings);
        //팔로워 , 팔로잉 이미지 조회
        List<FileVO> files = followService.selectFile();
        model.addAttribute("files", files);
        //팔로우의 일기수 조회
        List<FollowDTO> boards = followService.selectBoardCount();
        model.addAttribute("boards", boards);


        return "yourLife/yourLife";
    }





    //★☆★☆★☆★☆★☆★☆★☆★☆★☆ myLife의 userpage ★☆★☆★☆★☆★☆★☆★☆★☆
    @GetMapping("/userpage")
    public String userPage() {

        return "/yourLife/userpage";
    }

    // 유저 페이지 팔로우 기능 구현 컨트롤러
    @PostMapping("/userpage")
    public String userPage(@ModelAttribute("followVO") FollowVO followVO, HttpServletRequest request){
        //현재 사용자의 userId를 세션에서 가져오기
        Long userId = (Long) request.getSession().getAttribute("uniId");

        if (userId == null) {
            // userId가 없으면 에러 처리 또는 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        //followVO 에 userId(followToUser) 설정
        followVO.setFollowToUser(userId);
        System.out.println("followToUser 확인용 : "+followVO);

        //followId 설정
        followVO.setFollowId(followService.getFollowSeqNext());

       //followFromUser 설정 + 컨트롤러로 해당 유저 뿌린후 코드 작성





        return "redirect:/yourLife/userpage";
    }




}






