package com.campusMatch.CM.user.repository;

import com.campusMatch.CM.user.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities , Long> {
}
