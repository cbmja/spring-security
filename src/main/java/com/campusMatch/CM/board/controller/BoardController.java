package com.campusMatch.CM.board.controller;

import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.user.entity.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final HttpSession session;

    /*@RequestParam(name="type" , defaultValue = "notice") String type*/
    //게시판 목록
    @GetMapping()
    public String list( Model model, @ModelAttribute BoardData boardData){

        System.out.println(boardData+"list");
        model.addAttribute("boardData" , boardData);


        return "board/list";
    }

    //게시판 글 작성 폼
    @GetMapping("/form")
    public String form( Model model, @ModelAttribute BoardData boardData){

        System.out.println(boardData+"form");
        model.addAttribute("boardData" , boardData);
        if(session.getAttribute("member") != null){
            model.addAttribute("member" , (Member)session.getAttribute("member"));
        }

        return "board/form";
    }

    //작성 처리
    @PostMapping("/form")
    public String formProc(Model model, @ModelAttribute BoardData boardData){

        System.out.println(boardData+"proc");


        return "board/list";
    }


}
