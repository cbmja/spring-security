package com.campusMatch.CM.board.entity;


import com.campusMatch.CM.util.Base;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class BoardData extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardDataNum;//번호
    @Column
    private String userId;//글쓴이
    @Column
    private String title;//제목
    @Lob
    private String content;//내용

    @Column
    private String type;//notice 공지 , free 자유 , Question 질문
    @Column
    private int likes=0;//추천수
    @Column
    private int views=0;//조회수

    @Transient
    private String saveType="save"; //저장인지 수정인지

}
