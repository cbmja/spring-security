package com.campusMatch.CM.board.controller;

import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.board.repository.BoardDataRepository;
import com.campusMatch.CM.board.service.BoardDeleteService;
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

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {


    private final BoardSaveService boardSaveService;
    private final BoardInfoService boardInfoService;
    private final BoardDeleteService boardDeleteService;

    private final BoardDataRepository repository;

    /*@RequestParam(name="type" , defaultValue = "notice") String type*/
    //게시판 목록
    @GetMapping("/board")
    public String list(Model model, @ModelAttribute Search search){

        Pageable pageable = null;

        Page page = new Page(search.getPage(), boardInfoService.getTotal(search), 5 ,3);

        if(search.getSort().equals("ASC")){
            pageable = PageRequest.of(page.getPage(), 5, Sort.by("createdAt").ascending());
        }else{
            pageable = PageRequest.of(page.getPage(), 5, Sort.by("createdAt").descending());
        }

        model.addAttribute("page" , page);
        model.addAttribute("search" , search);

        model.addAttribute("list" , boardInfoService.getPageList(search,pageable).getContent());

        return "board/list";
    }

    @GetMapping("/board/detail")
    public String detail(Model model , @RequestParam(name = "boardId" , required = false)String boardId){

        model.addAttribute("boardData" , boardInfoService.findById(boardId));
        return "board/detail";
    }



    //게시판 글 작성 폼
    @GetMapping("/board/form")
    public String form( Model model, @ModelAttribute BoardData boardData){

        if(boardData.getSaveType().equals("edit")){
            boardData = boardInfoService.findById(boardData.getBoardDataNum()+"");
            boardData.setSaveType("edit");
        }

        model.addAttribute("boardData" , boardData);

        return "board/form";
    }

    //작성 처리
    @PostMapping("/board")
    public String formProc(Model model, @ModelAttribute BoardData boardData){

        boardSaveService.save(boardData);

        return "redirect:/board?type="+boardData.getType();
    }

    @PostMapping("/board/edit")
    public String edit(Model model, @ModelAttribute BoardData boardData){

        model.addAttribute("boardData" , boardData);

        return "redirect:/board?type="+boardData.getType();
    }

    @PostMapping("/board/delete")
    public String delete(Model model, @ModelAttribute BoardData boardData){

        boardDeleteService.delete(boardData);

        return "redirect:/board?type="+boardData.getType();
    }


}
