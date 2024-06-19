package com.campusMatch.CM.board.service;

import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.board.repository.BoardDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardDataRepository boardDataRepository;

    public void save(BoardData form){

        boardDataRepository.save(form);
    }

}
