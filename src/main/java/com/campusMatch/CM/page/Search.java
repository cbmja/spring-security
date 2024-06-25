package com.campusMatch.CM.page;

import lombok.Data;

@Data
public class Search {

    private String search =""; //
    private int page = 0;
    private String sort = "DESC"; //오름차순 , 내림차순 asc desc
    private String cate = "title"; //검색 항목 where 다음
    private String type ; //어떤 게시판인지
    private int startPage = 0;
    private int totalPage ;

    private String gender;


/*    public void setPage(int page) {
        if(page < 0){
            page = 0;
        }
        this.page = page;
    }*/
}
