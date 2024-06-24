package com.campusMatch.CM.user.repository;

import com.campusMatch.CM.user.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member , Long> {

    Member findByUserId(String username);

    boolean existsByEmail(String email);

    boolean existsByUserId(String email);

}
