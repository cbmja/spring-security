package com.campusMatch.CM.meeting.service;

import com.campusMatch.CM.meeting.entity.Apply;
import com.campusMatch.CM.meeting.repository.ApplyRepository;
import com.campusMatch.CM.page.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyInfoService {

    private final ApplyRepository applyRepository;


    public Page<Apply> getPageList(Search search , Pageable pageable){
        if(search.getGender().equals("ALL")){
            return applyRepository.findByALLCriteria(pageable);
        }else{
            return applyRepository.findByGenderCriteria(search, pageable);
        }




    }

    public int getTotal(Search search){
        if(search.getGender().equals("ALL")){
            return applyRepository.totalElement();
        }else {
            return applyRepository.totalElementGender(search);
        }
    }



}
