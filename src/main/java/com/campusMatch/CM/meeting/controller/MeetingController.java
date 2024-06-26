package com.campusMatch.CM.meeting.controller;

import com.campusMatch.CM.meeting.entity.Apply;
import com.campusMatch.CM.meeting.repository.ApplyRepository;
import com.campusMatch.CM.meeting.service.ApplyInfoService;
import com.campusMatch.CM.meeting.service.ApplySaveService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/meeting")
@RequiredArgsConstructor
public class MeetingController {

    private final HttpSession session;
    private final ApplySaveService applySaveService;
    private final ApplyInfoService applyInfoService;
    private final ApplyRepository applyRepository;


    @GetMapping("/apply")
    public String apply(Model model){

        if(session.getAttribute("member") == null){
            model.addAttribute("errMsg" , "미팅 신청을 위해서는 로그인이 필요합니다.");
            return "member/login";
        }

        return "meeting/apply";
    }

    @PostMapping("/apply")
    public String applyProc(Model model , @ModelAttribute Apply form){

        applySaveService.save(form);

        return "redirect:/";
    }

}
