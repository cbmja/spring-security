package com.campusMatch.CM.user.handler;

import com.campusMatch.CM.user.entity.Member;
import com.campusMatch.CM.user.service.MemberInfo;
import com.campusMatch.CM.user.service.MemberUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        MemberUtil.clearLoginData(session);

        /* 회원 정보 조회 편의 구현 */
        MemberInfo memberInfo = (MemberInfo) authentication.getPrincipal();
        Member member = memberInfo.getMember();
        session.setAttribute("member", member);

        String redirectURL = request.getParameter("redirectURL");
        redirectURL = StringUtils.hasText(redirectURL) ? redirectURL : "/";
        System.out.println("로그인 성공");
        //response.sendRedirect(request.getContextPath() + redirectURL);
        response.sendRedirect("/");
    }
}