package com.example.geungeunhanjan.controller;


import com.example.geungeunhanjan.domain.dto.FollowDTO;
import com.sun.source.tree.ForLoopTree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/yourLife")
public class YourLifeController {

<<<<<<< HEAD
    // myLife의 userpage
    @GetMapping("/userpage")
    public String userPage() {
        return "/myLife/userpage";
    }
=======
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
>>>>>>> 7bc2f127f563150cc982edd7850fb3ad34eb85b5

}






