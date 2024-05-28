package com.example.geungeunhanjan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class CommunityController {

    @GetMapping("/inquiry")
    public String community() {

        return "community/inquiry";
    }

    @GetMapping("/notification")
    public String notification() {
        return "community/notification";
    }

    @GetMapping("/notification/community_detail")
    public String notificationDetail() {
        return "community/community_detail";
    }
}


