package com.campusMatch.CM.user.util;

import com.campusMatch.CM.user.entity.Member;
import com.campusMatch.CM.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class JoinValidator {

    private final MemberRepository memberRepository;

    public Map<String , String> validate(Member form){

        Map<String , String> result = new HashMap<>();

        if(form.getUserId().isBlank()){
            result.put("id" , "id를 입력하세요");
        }

        if(!form.getUserId().isBlank()){
            if(memberRepository.existsByUserId(form.getUserId())){
                result.put("duplication_id" , "중복된 아이디 입니다.");
            }
        }

        if(form.getEmail().isBlank()){
            result.put("email" , "email을 입력하세요");
        }

        if(!form.getEmail().isBlank()){
            if(memberRepository.existsByEmail(form.getEmail())){
                result.put("duplication_email" , "해당 이메일로 가입된 계정이 존재합니다.");
            }
        }

        if(form.getPassword().isBlank()){
            result.put("password" , "비밀번호를 입력하세요");
        }
        if(form.getPassword2().isBlank()){
            result.put("password2" , "비밀번호 확인을 입력하세요");
        }
        if(form.getKakaoId().isBlank()){
            result.put("kakao" , "카카오톡 아이디를 입력하세요");
        }
        if(form.getCampusCode().isBlank()){
            result.put("campus" , "학교를 선택하세요");
        }
        if(form.getMemberLoc().isBlank()){
            result.put("location" , "거주지를 선택하세요");
        }
        if(form.getYyyy().isBlank() || form.getMm().isBlank() || form.getDd().isBlank()){
            result.put("birth" , "생년월일을 확인하세요");
        }
        if(form.getGender() == null){
            result.put("gender" , "성별을 선택하세요");
        }

        if(form.getAgree() == null){
            result.put("agree" , "약관 확인");
        }

        if(!form.getPassword().isBlank() && !form.getPassword2().isBlank()){
            if(!form.getPassword().equals(form.getPassword2())){
                result.put("pwConfirm" , "비밀번호 확인이 틀렸습니다.");
            }
        }
        return result;
    }

}
