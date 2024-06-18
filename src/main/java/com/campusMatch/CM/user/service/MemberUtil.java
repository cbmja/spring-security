package com.campusMatch.CM.user.service;

import com.campusMatch.CM.user.Authority;
import com.campusMatch.CM.user.entity.Authorities;
import com.campusMatch.CM.user.entity.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberUtil {

    private final HttpSession session;

    public boolean isAdmin() {

        if (isLogin()) {
            return getMember().getAuthorities()
                    .stream().map(Authorities::getAuthority)
                    .anyMatch(a -> a == Authority.ADMIN || a == Authority.MANAGER);
        }

        return false;
    }

    public boolean isLogin() {

        return getMember() != null;
    }

    public Member getMember() {
        Member member = (Member) session.getAttribute("member");

        return member;
    }

    public static void clearLoginData(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("NotBlank_username");
        session.removeAttribute("NotBlank_password");
        session.removeAttribute("Global_error");
    }

}