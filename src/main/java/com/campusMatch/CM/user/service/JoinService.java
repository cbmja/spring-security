package com.campusMatch.CM.user.service;

import com.campusMatch.CM.user.Authority;
import com.campusMatch.CM.user.entity.Authorities;
import com.campusMatch.CM.user.entity.Member;
import com.campusMatch.CM.user.repository.AuthoritiesRepository;
import com.campusMatch.CM.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

@Service
@RequiredArgsConstructor
@Transactional
public class JoinService {

    private final MemberRepository memberRepository;
    private final AuthoritiesRepository authoritiesRepository;
    //private final JoinValidator validator;
    private final PasswordEncoder encoder;

    public void process(Member form) {
        /*
        validator.validate(form, errors);
        if (errors.hasErrors()) {
            return;
        }
*/
        // 비밀번호 BCrypt로 해시화
        String hash = encoder.encode(form.getPassword());

        //Member member = new ModelMapper().map(form, Member.class);
        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setName(form.getName());
        member.setPassword(hash);
        member.setUserId(form.getUserId());

        process1(member);

        // 회원 가입시에는 일반 사용자 권한 부여(USER)
        Authorities authorities = new Authorities();
        authorities.setMember(member);
        authorities.setAuthority(Authority.USER);
        authoritiesRepository.saveAndFlush(authorities);


    }

    public void process1(Member member) {
        memberRepository.saveAndFlush(member);
    }
}