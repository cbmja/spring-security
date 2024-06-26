package com.campusMatch.CM.board.controller;

import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.board.repository.BoardDataRepository;
import com.campusMatch.CM.board.service.BoardDeleteService;
import com.campusMatch.CM.board.service.BoardInfoService;
import com.campusMatch.CM.board.service.BoardSaveService;
import com.campusMatch.CM.page.Search;
import com.campusMatch.CM.util.Page;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
//@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {


    private final BoardSaveService boardSaveService;
    private final BoardInfoService boardInfoService;
    private final BoardDeleteService boardDeleteService;

    private final BoardDataRepository repository;
    private final HttpServletRequest request;

    //메뉴 바로 접근 ok
    //검색으로 접근 ok
    //페이지 블럭으로 접근 ok
    //게시판 목록
    @GetMapping("/board")
    public String list(Model model, @ModelAttribute Search search){

        //pageElement - 한 페이지에 보여줄 게시물 수 / pageSize - 페이지 블럭 수
        Page page = new Page(search.getPage(), boardInfoService.getTotal(search), 10 ,3);
        Pageable pageable = getPageable(search.getSort() , page.getPage() , page.getPageElement());

        model.addAttribute("page" , page);
        model.addAttribute("search" , search);
        model.addAttribute("list" , boardInfoService.getPageList(search,pageable).getContent());

        return "board/list";
    }

    //ok
    //상세 페이지
    @GetMapping("/board/detail")
    public String detail(Model model , @RequestParam(name = "boardId" , required = false)int boardId){

        model.addAttribute("boardData" , boardInfoService.findById(boardId));
        return "board/detail";
    }

    //새 작성 ok
    //수정 ok
    //게시판 글 작성 폼
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/board/form")
    public String form( Model model, @ModelAttribute BoardData boardData ){

        if(boardData.getSaveType().equals("edit")){
            boardData = boardInfoService.findById(boardData.getBoardDataNum());
            boardData.setSaveType("edit");
        }

        model.addAttribute("boardData" , boardData);

        //model.addAttribute("titleErrMsg" , "");
        //model.addAttribute("contentErrMsg" , "");

        return "board/form";
    }

    //ok
    //작성 처리
    //수정 처리
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/board")
    public String formProc(Model model, @ModelAttribute BoardData boardData){

        if(boardData.getTitle().isBlank() && boardData.getContent().isBlank()){
            model.addAttribute("contentErrMsg" , "내용을 입력 하세요");
            model.addAttribute("titleErrMsg" , "제목을 입력 하세요");
            model.addAttribute("boardData" , boardData);
            return "board/form";
        }else if(boardData.getContent().isBlank()){
            model.addAttribute("contentErrMsg" , "내용을 입력 하세요");
            model.addAttribute("boardData" , boardData);
            return "board/form";
        }else if(boardData.getTitle().isBlank()){
            model.addAttribute("titleErrMsg" , "제목을 입력 하세요");
            model.addAttribute("boardData" , boardData);
            return "board/form";
        }else{
            boardSaveService.save(boardData);
            return "redirect:/board?type="+boardData.getType();
        }



    }
/*
    @PostMapping("/board/edit")
    public String edit(Model model, @ModelAttribute BoardData boardData){

        model.addAttribute("boardData" , boardData);

        return "redirect:/board?type="+boardData.getType();
    }
*/

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/board/delete")
    public String delete(Model model, @ModelAttribute BoardData boardData){

        boardDeleteService.delete(boardData.getBoardDataNum());

        return "redirect:/board?type="+boardData.getType();
    }


    private Pageable getPageable(String sort , int page , int pageElement){
        Pageable pageable = null;
        if(sort.equals("ASC")){
            pageable = PageRequest.of(page, 5, Sort.by("createdAt").ascending());
        }else{
            pageable = PageRequest.of(page, 5, Sort.by("createdAt").descending());
        }
        return pageable;
    }


}
