package com.campusMatch.CM.user.controller;

import com.campusMatch.CM.user.entity.Member;
import com.campusMatch.CM.user.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final JoinService joinService;

    /**
     * 로그인 페이지인데 모달이라 없어도 될듯
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return null;
    }


/**
     * 로그아웃
     * @return
     */

    @GetMapping("/logout")
    public String logout(){
        return null;
    }


    /**
     * 회원가입 처리
     * @return
     */
    @PostMapping("/join")
    public String join(@ModelAttribute Member form){
        joinService.process(form);
        return "redirect:/";
    }
    
    

}
