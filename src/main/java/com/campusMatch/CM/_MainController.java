package com.campusMatch.CM;

import com.campusMatch.CM.meeting.entity.Apply;
import com.campusMatch.CM.meeting.service.ApplyInfoService;
import com.campusMatch.CM.page.Search;
import com.campusMatch.CM.user.entity.Gender;
import com.campusMatch.CM.user.entity.Member;
import com.campusMatch.CM.util.Page;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class _MainController {

    private final ApplyInfoService applyInfoService;
    private final HttpSession session;

    @GetMapping("/")
    public String main(Model model , Search search){


        if(session.getAttribute("member") != null && ((Member)session.getAttribute("member")).getGender().equals(Gender.M)){
            search.setGender("F");
        }else{
            search.setGender("M");
        }

        //pageElement - 한 페이지에 보여줄 게시물 수 / pageSize - 페이지 블럭 수
        Page page = new Page(search.getPage(), applyInfoService.getTotal(search), 8 ,3);
        Pageable pageable = PageRequest.of(page.getPage(), page.getPageElement());

        model.addAttribute("page" , page);
        model.addAttribute("search" , search);
        model.addAttribute("list" , applyInfoService.getPageList(search,pageable).getContent());



        return "index";
    }

}
