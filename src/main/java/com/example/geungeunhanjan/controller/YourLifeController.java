package com.example.geungeunhanjan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/yourLife")
public class YourLifeController {

    @GetMapping("/boardList")
    public String boardList() {
        return "boardList";
    }
}
