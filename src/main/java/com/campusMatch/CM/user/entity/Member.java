package com.campusMatch.CM.user.entity;

import com.campusMatch.CM.util.Base;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Member extends Base {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq; //번호

    @Column(length=80, nullable = false, unique = true)
    private String email; //이메일

    @Column(length=40, nullable = false, unique = true)
    private String userId; //아이디

    @Column(length=65, nullable = false)
    private String password; //비밀번호

    @Column(nullable=false)
    private String kakaoId; //카톡아이디

    @Column(nullable=false)
    private String campusCode; //학교 코드

    @Column(nullable=false)
    private String memberLoc; //거주지

    @Column(nullable=false)
    private Gender gender; //성별

    @Column(nullable=false)
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date birthDate; //생년월일

    @Column(nullable=false)
    private int applyCnt=0; //신청 횟수

    @Column(nullable=false)
    private int matchCnt=0; //매칭 횟수

    @Transient
    private String agree; //회원가입 동의
    @Transient
    private String yyyy;
    @Transient
    private String mm;
    @Transient
    private String dd;
    @Transient
    private String password2;

    @ToString.Exclude
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Authorities> authorities = new ArrayList<>(); //권한
    //사용가능여부

    @Column
    private boolean enable = true; //계정 사용 가능 여부

    @Column(name="_lock")
    //계정 잠금 여부
    private boolean lock = false; //계정 잠김 여부


}