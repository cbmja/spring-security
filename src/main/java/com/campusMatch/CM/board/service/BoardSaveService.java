package com.campusMatch.CM.board.service;

import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.board.repository.BoardDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardDataRepository boardDataRepository;
    private final BoardInfoService boardInfoService;

    public void save(BoardData form){

        if(form.getSaveType().equals("edit")){
           BoardData boardData = boardInfoService.findById(form.getBoardDataNum());
           boardData.setTitle(form.getTitle());
           boardData.setContent(form.getContent());
           boardDataRepository.saveAndFlush(boardData);

        }else{
            boardDataRepository.saveAndFlush(form);
        }


    }

}
