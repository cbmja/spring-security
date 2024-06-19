package com.campusMatch.CM.view_option;

import java.util.LinkedHashMap;
import java.util.List;

public class NavMenu {

    //모달이 있어서 잠시 보류
    /**
     * 상단 메뉴
     * @return
     */
    public static LinkedHashMap<String , String> getMenu(){

        LinkedHashMap<String , String> navMenu = new LinkedHashMap<>();
        navMenu.put("공지 사항" , "/board?type=notice");
        navMenu.put("미팅 신청" , "/board?type=notice");
        navMenu.put("공지사항" , "/board?type=notice");
        navMenu.put("공지사항" , "/board?type=notice");
        navMenu.put("공지사항" , "/board?type=notice");
        return null;
    }

}
