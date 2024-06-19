package com.campusMatch.CM.board.entity;


import com.campusMatch.CM.util.Base;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class BoardData extends Base {

    @Id
    @GeneratedValue
    private int boardDataNum;//번호
    @Column
    private String memberId;//글쓴이
    @Column
    private String title;//제목
    @Lob
    private String content;//내용

    @Column
    private String type;//notice 공지 , free 자유 , Question 질문
    @Column
    private int likes;//추천수
    @Column
    private int views;//조회수

}
