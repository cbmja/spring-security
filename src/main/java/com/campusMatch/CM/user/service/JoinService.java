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

import java.text.SimpleDateFormat;
import java.util.Date;

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
        String dateStr = form.getYyyy()+"-"+form.getMm()+"-"+form.getDd();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date BD = formatter.parse(dateStr);
            form.setBirthDate(BD);
        }catch (Exception e){
            e.printStackTrace();
        }

        // 비밀번호 BCrypt로 해시화
        String hash = encoder.encode(form.getPassword());

        //Member member = new ModelMapper().map(form, Member.class);
        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(hash);
        member.setUserId(form.getUserId());
        member.setMemberLoc(form.getMemberLoc());
        member.setKakaoId(form.getKakaoId());
        member.setCampusCode(form.getCampusCode());
        member.setBirthDate(form.getBirthDate());
        member.setApplyCnt(0);
        member.setMatchCnt(0);
        member.setGender(form.getGender());


        process1(member);

        // id가 admin 이면 관리자 권한 부여
        Authorities authorities = new Authorities();
        authorities.setMember(member);

        if(member.getUserId().equals("admin")){
            authorities.setAuthority(Authority.ADMIN);
        }else {
            authorities.setAuthority(Authority.USER);
        }

        authoritiesRepository.saveAndFlush(authorities);


    }

    protected void process1(Member member) {
        memberRepository.saveAndFlush(member);
    }
}