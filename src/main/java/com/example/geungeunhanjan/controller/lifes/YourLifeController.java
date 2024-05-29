package com.example.geungeunhanjan.controller.lifes;


import com.example.geungeunhanjan.domain.dto.file.FollowDTO;
import com.example.geungeunhanjan.domain.vo.file.FileVO;
import com.example.geungeunhanjan.service.lifes.FollowService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


        List<FollowDTO> followers = followService.selectFollower();
        model.addAttribute("followers", followers);

        List<FollowDTO> followings = followService.selectFollowing();
        model.addAttribute("followings", followings);

        List<FileVO> files = followService.selectFile();
        model.addAttribute("files", files);

        List<FollowDTO> boards = followService.selectBoardCount();
        model.addAttribute("boards", boards);


        return "yourLife/yourLife";
    }





    // myLife의 userpage
    @GetMapping("/userpage")
    public String userPage() {

        return "/yourLife/userpage";
    }

//    private final com.example.geungeunhanjan.service.mdjFollowService mdjFollowService;
//
//    public YourLifeController(com.example.geungeunhanjan.service.mdjFollowService mdjFollowService) {
//        this.mdjFollowService = mdjFollowService;
//    }

//    @GetMapping("/yourLife")
//    public String userPage(Model model) {
//
//        List<FollowDTO> followers = mdjFollowService.selectFollower();
//        model.addAttribute("followers", followers);
//
//        List<FollowDTO> followings = mdjFollowService.selectFollowing();
//        model.addAttribute("followings", followings);
//
//        return "/yourLife/yourLife";
//    }


}






