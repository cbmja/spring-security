package com.campusMatch.CM.util;

import com.campusMatch.CM.page.Search;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Page {

    private int total;//총 게시물 수 ok

    private int pageElement = 7;//한 페이지에 보여줄 게시물 수 ok
    private int pageSize = 4;//보여줄 페이지 블럭 수 ok

    private int startPage;//보여지는 블럭의 시작번호 ok
    private int endPage;//보여지는 블럭의 마지막 번호 ok

    private List<Integer> elements;

    private int page; //현재 페이지 ok
    private int totalPageCnt;//총 페이지 수 ok
    private int totalEndPage;//제일 마지막 페이지 ok

    private int startNum;//첫 게시물 번호 ok
    private int endNum;//마지막 게시물 번호 ok


    //private int currentPageBlock;//현재 보이는 페이지 블럭 수

    private boolean next;//다음페이지 존재 여부
    private boolean prev;//이전페이지 존재 여부

    private int prev_;
    private int next_;

    private int front = 0;

    /**
     *
     * @param page 현재 페이지
     * @param total 총 게시물 수
     * @param pageElement 페이지당 게시물 수
     * @param pageSize 페이지블럭 수
     */
    public Page(int page , int total , int pageElement , int pageSize){
        this.page = page; //현재 페이지

        this.total = total; //총 게시물 수
        this.pageElement = pageElement; //페이지당 보여줄 게시물 수
        this.pageSize = pageSize; //페이지블럭 수

        this.totalPageCnt = total % this.pageElement > 0 ? total / this.pageElement + 1 : total / this.pageElement; //총 페이지 수

        this.totalEndPage = totalPageCnt - 1; //마지막 페이지 번호

        //현재 페이지가 0보다 작으면 0 , 마지막 페이지보다 크면 마지막 페이지로
        if(this.page > this.totalEndPage){
            this.page = this.totalEndPage;
        }
        if(this.page < 0){
            this.page = 0;
        }


        this.startNum = this.page * this.pageElement; //페이지의 첫 게시물 인덱스
        this.endNum = this.page == this.totalEndPage ? this.total -1 : startNum + this.pageElement - 1; //페이지의 마지막 게시물 인덱스
        //this.endNum = this.page == this.totalEndPage ? this.total : startNum + this.pageElement - 1; //아니면 이걸로


        this.startPage = (this.page / this.pageSize) * this.pageSize; //시작 페이지 블럭
        this.endPage = this.startPage + this.pageSize -1 > this.totalEndPage ? this.totalEndPage : this.startPage + this.pageSize -1; //끝 페이지 블럭

        List<Integer> list = new ArrayList<>();

        for(int k = this.startPage; k<=this.endPage; k++){
            list.add(k);
        }

        this.elements = list;

/*
        if(this.startPage == 1){
            this.prev = false;
        }else{
            this.prev = true;
        }

        if(this.endPage == this.totalPage){
            this.next = false;
        }else{
            this.next = true;
        }

        if(this.prev){ this.prev_ = this.startPage -1;
        }else{this.prev_ =1;}

        if(this.next){this.next_ = this.endPage+1;
        }else{this.next_ = this.totalPage;}
*/



    }
}
/*

@Data
public class Page {



    private String search;
    private String sort;
    private String cate;

    private List<Integer> elements;

    private int total;//총 게시물 수 ok

    private int pageElement = 7;//한 페이지에 보여줄 게시물 수 ok
    private int pageSize = 4;//보여줄 페이지 블럭 수 ok

    private int startPage;//보여지는 블럭의 시작번호
    private int endPage;//보여지는 블럭의 마지막 번호


    private int page=0; //현재 페이지 ok
    private int totalPage;//총 페이지 수

    private int startNum;//첫 게시물 번호 ok
    private int endNum;//마지막 게시물 번호 ok

    //private int currentPageBlock;//현재 보이는 페이지 블럭 수

    private boolean next;//다음페이지 존재 여부
    private boolean prev;//이전페이지 존재 여부

    private int prev_;
    private int next_;

    */
/**
     * 현재페이지 , 총 게시물 수
     * @param page
     * @param total
     *//*

    public Page(int page , int total , Search search){

        this.search = search.getSearch().trim();
        this.cate = search.getCate();
        this.sort = search.getSort();

        this.total = total;
        this.totalPage = total % this.pageElement > 0 ? total / this.pageElement + 1 : total / this.pageElement;

        this.page = page;
        if(this.page > this.totalPage){
            this.page = this.totalPage;
        }


        this.startNum = (this.page - 1)*this.pageElement < 0 ? 0 : (this.page - 1)*this.pageElement;
        this.endNum = this.page == this.totalPage ? this.total : startNum + this.pageElement - 1;


        this.endPage = (( this.startNum / (this.pageElement * this.pageSize) ) * this.pageSize) + this.pageSize > this.totalPage
                ? this.totalPage : (( this.startNum / (this.pageElement * this.pageSize) ) * this.pageSize) + this.pageSize;

        this.startPage = ((( this.startNum / (this.pageElement * this.pageSize) ) * this.pageSize) + this.pageSize)-this.pageSize;

        if(this.totalPage % this.pageSize == 0){

        }else{
            if(this.totalPage > this.pageSize){

            }
            if(this.totalPage < this.pageSize){

            }

        }

        if(this.startPage == 0){
            this.prev = false;
        }else{
            this.prev = true;
        }

        if(this.endPage == this.totalPage){
            this.next = false;
        }else{
            this.next = true;
        }

        if(this.prev){ this.prev_ = this.startPage -1;
        }else{this.prev_ =1;}

        if(this.next){this.next_ = this.endPage+1;
        }else{this.next_ = this.totalPage;}


        List<Integer> list = new ArrayList<>();
         // +1 해야될수도 있음 -1 일수도 해보고 이상하면 수정
        for(int k=this.startPage; k<(this.startPage + (this.endPage - this.startPage)); k++){
            list.add(k);
        }

        this.elements = list;




    }


}*/
