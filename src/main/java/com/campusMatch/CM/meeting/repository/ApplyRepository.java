package com.campusMatch.CM.meeting.repository;

import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.meeting.entity.Apply;
import com.campusMatch.CM.page.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<Apply , Integer> {


    @Query("SELECT a FROM Apply a WHERE a.gender = :#{#search.gender}")
    Page<Apply> findByGenderCriteria(@Param("search") Search search, Pageable pageable);

    @Query("SELECT a FROM Apply a")
    Page<Apply> findByALLCriteria(Pageable pageable);

    @Query("SELECT count(*) FROM Apply a WHERE a.gender = :#{#search.gender}")
    int totalElementGender(@Param("search")Search search);


    @Query("SELECT count(*) FROM Apply")
    int totalElement();
}
