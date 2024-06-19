package com.campusMatch.CM.page;

import lombok.Data;

@Data
public class Search {

    private String search ="";
    private int page = 1;
    private String sort = "DESC"; //오름차순 , 내림차순 asc desc
    private String cate = "title"; //검색 항목 where 다음
    private String type ;
    private int startPage = 0;

}
