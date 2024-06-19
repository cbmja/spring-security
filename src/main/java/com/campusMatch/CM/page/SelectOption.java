package com.campusMatch.CM.page;

import java.util.ArrayList;
import java.util.List;

public class SelectOption {

    /**
     * 검색 카테고리
     * @return
     */
    public static List<String> getCateList(){
        List<String> cateList = new ArrayList<>();
        cateList.add("title");
        cateList.add("content");
        cateList.add("createdAt");
        return cateList;
    }

    /**
     * 오름차순 내림차순
     * @return
     */
    public static List<String> getSortList(){
        List<String> sortList = new ArrayList<>();
        sortList.add("ASC");
        sortList.add("DESC");
        return sortList;
    }

}
