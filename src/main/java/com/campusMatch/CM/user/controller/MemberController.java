package com.campusMatch.CM.user.controller;

import com.campusMatch.CM.user.entity.Member;
import com.campusMatch.CM.user.service.JoinService;
import com.campusMatch.CM.user.util.JoinValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final JoinService joinService;
    private final JoinValidator joinValidator;

    /**
     * 로그인 페이지
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "member/login";
    }


    @GetMapping("/join")
    public String join(Model model,@ModelAttribute Member form){
        Map<String , String> errMag = new HashMap<>();
        model.addAttribute("form" , form);
        model.addAttribute("errMsg" , errMag);
        return "member/join";
    }

    @GetMapping("/apply")
    public String apply(){
        return "member/apply";
    }


/**
     * 로그아웃
     * @return
     */

    @GetMapping("/logout")
    public String logout(){
        return "null";
    }


    /**
     * 회원가입 처리
     * @return
     */
    @PostMapping("/join")
    public String join_(Model model, @ModelAttribute Member form){

        Map<String , String> errMsg = joinValidator.validate(form);

        if(errMsg.isEmpty()){
            joinService.process(form);
            return "redirect:/";
        }else {
            model.addAttribute("errMsg" , errMsg);
            model.addAttribute("form" , form);
            return "member/join";
        }




    }
    
    

}
