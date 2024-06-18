package com.campusMatch.CM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestCon {

    @GetMapping("/myPage/sdsd")
    public String a1(){
        return "myPage";
    }
    @GetMapping("/admin/sdsd")
    public String a2(){
        return "admin";
    }
    @GetMapping("/")
    public String a3(){
        return "/";
    }
    @GetMapping("/member/login")
    public String a4(){
        return "login";
    }

    @PostMapping("/member/login")
    public String a5(){
        return "loginpost";
    }

}
