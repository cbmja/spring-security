package com.campusMatch.CM.meeting.service;

import com.campusMatch.CM.meeting.entity.Apply;
import com.campusMatch.CM.meeting.repository.ApplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ApplySaveService {

    private final ApplyRepository applyRepository;


    public void save(Apply form){

        String path = "C:\\campusData\\"+form.getUserId()+"\\";

        form.setDirPath(path);
        savePdf(form);
        applyRepository.saveAndFlush(form);


    }
    public void savePdf(Apply form){

        String path = form.getDirPath();

        if(!form.getPhoto1().isEmpty() && form.getPhoto1() != null){
            /////SSSpdf 저장SSS/////
            MultipartFile file = form.getPhoto1();

            String fileName = file.getOriginalFilename();

            //디렉토리 생성
            File dir = new File(path);
            dir.mkdirs();

            //파일 저장처리SSS
            Path pdfPath = Paths.get(path).resolve(fileName);

            try {
                file.transferTo(pdfPath.toFile());
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            form.setFileName1(fileName);
        }

        if(!form.getPhoto2().isEmpty() && form.getPhoto2() != null){
            /////SSSpdf 저장SSS/////
            MultipartFile file = form.getPhoto2();

            String fileName = file.getOriginalFilename();

            //디렉토리 생성
            File dir = new File(path);
            dir.mkdirs();

            //파일 저장처리SSS
            Path pdfPath = Paths.get(path).resolve(fileName);

            try {
                file.transferTo(pdfPath.toFile());
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            form.setFileName2(fileName);
        }

        if(!form.getPhoto3().isEmpty() && form.getPhoto3() != null){
            /////SSSpdf 저장SSS/////
            MultipartFile file = form.getPhoto3();

            String fileName = file.getOriginalFilename();

            //디렉토리 생성
            File dir = new File(path);
            dir.mkdirs();

            //파일 저장처리SSS
            Path pdfPath = Paths.get(path).resolve(fileName);

            try {
                file.transferTo(pdfPath.toFile());
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            form.setFileName3(fileName);
        }

    }

}
