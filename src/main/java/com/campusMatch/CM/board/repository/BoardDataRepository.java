package com.campusMatch.CM.board.repository;

import com.campusMatch.CM.board.entity.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDataRepository extends JpaRepository<BoardData , Integer> {
}
