package com.campusMatch.CM.board.entity;


import com.campusMatch.CM.util.Base;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Comment extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNum;//번호
    @Column
    private int boardDataNum;//게시글 번호
    @Lob
    private String content;//내용
    @Column
    private String memberId;//글쓴이

    @Column
    private int likes;//추천수

}
