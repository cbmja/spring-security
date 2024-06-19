package com.campusMatch.CM.board.repository;



import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.page.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardDataRepository extends JpaRepository<BoardData, Integer> {


    /**
     * 제목검색
     * @param search
     * @param pageable
     * @return
     */
    @Query("SELECT d FROM BoardData d WHERE d.type = :#{#search.type} AND d.title LIKE %:#{#search.search}%")
    Page<BoardData> findByTitleCriteria(@Param("search")Search search, Pageable pageable);

    /**
     * 내용검색
     * @param search
     * @param pageable
     * @return
     */
    @Query("SELECT d FROM BoardData d WHERE d.type = :#{#search.type} AND d.content LIKE %:#{#search.search}%")
    Page<BoardData> findByContentCriteria(@Param("search")Search search, Pageable pageable);

    /**
     * 글쓴이 검색
     * @param search
     * @param pageable
     * @return
     */
    @Query("SELECT d FROM BoardData d WHERE d.type = :#{#search.type} AND d.userId LIKE %:#{#search.search}%")
    Page<BoardData> findByUserIdCriteria(@Param("search")Search search, Pageable pageable);
}
