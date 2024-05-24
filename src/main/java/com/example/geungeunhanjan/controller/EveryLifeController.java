package com.example.geungeunhanjan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/everyLife")
public class EveryLifeController {

    @GetMapping("/detail-others")

    public String everyDetailOthers() {
        return "myLife/detail-others";
    }
}
