package com.campusMatch.CM.board.service;

import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.board.repository.BoardDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardInfoService {

    private final BoardDataRepository boardDataRepository;

    public List<BoardData> getAll(){
        return boardDataRepository.findAll();
    }

}
