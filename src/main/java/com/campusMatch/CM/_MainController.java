package com.campusMatch.CM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class _MainController {

    @GetMapping("/")
    public String main(){
        return "index";
    }

}
