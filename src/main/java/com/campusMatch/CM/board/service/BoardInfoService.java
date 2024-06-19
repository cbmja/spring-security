package com.campusMatch.CM.board.service;

import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.board.repository.BoardDataRepository;
import com.campusMatch.CM.page.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardInfoService {

    private final BoardDataRepository boardDataRepository;

    public List<BoardData> getAll(){
        return boardDataRepository.findAll();
    }

    public Page<BoardData> getPageList(Search search, Pageable pageable) {
        if(search.getCate().equals("title")){
            return boardDataRepository.findByTitleCriteria(search, pageable);
        } else if (search.getCate().equals("content")) {
            return boardDataRepository.findByContentCriteria(search, pageable);
        } else{
            return boardDataRepository.findByUserIdCriteria(search, pageable);
        }

    }

}
