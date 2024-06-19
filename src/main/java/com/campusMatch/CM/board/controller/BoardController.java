package com.campusMatch.CM.board.controller;

import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.board.repository.BoardDataRepository;
import com.campusMatch.CM.board.service.BoardInfoService;
import com.campusMatch.CM.board.service.BoardSaveService;
import com.campusMatch.CM.page.Search;
import com.campusMatch.CM.user.entity.Member;
import com.campusMatch.CM.util.Page;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {


    private final BoardSaveService boardSaveService;
    private final BoardInfoService boardInfoService;

    private final BoardDataRepository repository;

    /*@RequestParam(name="type" , defaultValue = "notice") String type*/
    //게시판 목록
    @GetMapping("/board")
    public String list(Model model, @ModelAttribute Search search){

        Pageable pageable = PageRequest.of(search.getPage(), 5, Sort.by("createdAt").ascending());

        Page page = new Page(search.getPage(), boardInfoService.getTotal(search), search);

        model.addAttribute("page" , page);
        search.setTotalPage(pageable.getPageSize());

        model.addAttribute("search" , search);



        List<BoardData> bList = boardInfoService.getPageList(search,pageable).getContent();


        model.addAttribute("list" , boardInfoService.getPageList(search,pageable).getContent());

        return "board/list";
    }



    //게시판 글 작성 폼
    @GetMapping("/board/form")
    public String form( Model model, @ModelAttribute BoardData boardData){

        model.addAttribute("boardData" , boardData);


        return "board/form";
    }

    //작성 처리
    @PostMapping("/board")
    public String formProc(Model model, @ModelAttribute BoardData boardData){

        boardSaveService.save(boardData);


        return "redirect:/board?type="+boardData.getType();
    }


}
