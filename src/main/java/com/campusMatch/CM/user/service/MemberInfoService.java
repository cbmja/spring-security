package com.campusMatch.CM.user.service;

import com.campusMatch.CM.user.entity.Authorities;
import com.campusMatch.CM.user.entity.Member;
import com.campusMatch.CM.user.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberInfoService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final HttpServletRequest request;
    private final EntityManager em;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByUserId(username); //아이디 조회

        List<SimpleGrantedAuthority> authorities = null;
        List<Authorities> tmp = member.getAuthorities();
        if (tmp != null) {
            authorities = tmp.stream()
                    .map(s -> new SimpleGrantedAuthority(s.getAuthority().name()))
                    .toList();
        }


        return MemberInfo.builder()
                .email(member.getEmail())
                .userId(member.getUserId())
                .password(member.getPassword())
                .member(member)
                .authorities(authorities)
                .enable(member.isEnable())
                .lock(member.isLock())
                .build();
    }
/*
     * 회원 목록
     *
     * @param search
     * @return

    public ListData<Member> getList(MemberSearch search) {

        int page = Utils.onlyPositiveNumber(search.getPage(), 1); // 페이지 번호
        int limit = Utils.onlyPositiveNumber(search.getLimit(), 20); // 1페이지당 레코드 갯수
        int offset = (page - 1) * limit; // 레코드 시작 위치 번호

        BooleanBuilder andBuilder = new BooleanBuilder();
        QMember member = QMember.member;

         검색 조건 처리 S

        String sopt = search.getSopt();
        sopt = StringUtils.hasText(sopt) ? sopt.trim() : "ALL";
        String skey = search.getSkey(); // 키워드

        // 조건별 키워드 검색
        if (StringUtils.hasText(skey)) {
            skey = skey.trim();

            BooleanExpression UserIdcond = member.userId.contains(skey);
            BooleanExpression Namecond = member.name.contains(skey);
            BooleanExpression SchoolNamecond = member.school.schoolName.contains(skey);
            //BooleanExpression authority = member.authority.contains(skey);

            if (sopt.equals("userId")) {
                andBuilder.and(UserIdcond);
            } else if (sopt.equals("name")) {
                andBuilder.and(Namecond);
            } else if (sopt.equals("schoolName")) {
                andBuilder.and(SchoolNamecond);
            } else { // 통합검색 : userId + name
                BooleanBuilder orBuilder = new BooleanBuilder();
                orBuilder.or(UserIdcond)
                        .or(Namecond)
                        .or(SchoolNamecond);
                andBuilder.and(orBuilder);
            }
        }

         검색 조건 처리 E

        PathBuilder<Member> pathBuilder = new PathBuilder<>(Member.class, "member");

        List<Member> items = new JPAQueryFactory(em)
                .selectFrom(member)
                .leftJoin(member.authorities)
                .fetchJoin()
                .where(andBuilder)
                .limit(limit)
                .offset(offset)
                .orderBy(new OrderSpecifier(Order.DESC, pathBuilder.get("createdAt")))
                .fetch();

         페이징 처리 S
        int total = (int)memberRepository.count(andBuilder); // 총 레코드 갯수

        Pagination pagination = new Pagination(page, total, 10, limit, request);
         페이징 처리 E

        return new ListData<>(items, pagination);
    }
*/



}