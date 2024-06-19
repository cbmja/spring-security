package com.campusMatch.CM.user.entity;

import com.campusMatch.CM.user.Authority;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(indexes=@Index(name="uq_member_authority", columnList = "member_seq, authority", unique = true))
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="member_seq")
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(length=15, nullable = false)
    private Authority authority;
}