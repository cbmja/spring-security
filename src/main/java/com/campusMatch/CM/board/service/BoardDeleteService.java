package com.campusMatch.CM.board.service;

import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.board.repository.BoardDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardDeleteService {

    private final BoardDataRepository boardDataRepository;


    public void delete(BoardData boardData){
        boardDataRepository.delete(boardData);
    }

}
