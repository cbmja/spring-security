package com.campusMatch.CM.board.repository;

import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.page.Page;
import com.campusMatch.CM.page.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardDataRepository extends JpaRepository<BoardData , Integer> {




}
