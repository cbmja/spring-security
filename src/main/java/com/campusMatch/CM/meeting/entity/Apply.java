package com.campusMatch.CM.meeting.entity;

import com.campusMatch.CM.util.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Data
public class Apply extends Base {

    @Id
    @GeneratedValue
    private int num;

    private String kakaoUrl; //오픈카톡방 url

    private String loc; //희망 지역

    private int groupCnt; //인원
    
    private String dirPath; //경로

    private String fileName1; //파일명

    private String fileName2;

    private String fileName3;

    private String userId; //신청자 아이디

    private String kakaoId; //카톡 아이디

    private String gender; //성별


    @Transient
    private MultipartFile photo1;
    @Transient
    private MultipartFile photo2;
    @Transient
    private MultipartFile photo3;



}
