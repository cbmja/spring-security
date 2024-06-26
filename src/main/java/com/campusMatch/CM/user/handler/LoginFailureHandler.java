package com.campusMatch.CM.user.handler;

import com.campusMatch.CM.user.service.MemberUtil;
import com.campusMatch.CM.util.Utils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;

import java.io.IOException;


public class LoginFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        HttpSession session = request.getSession();



        // 세션 로그인 실패 메세지 일괄 삭제
        MemberUtil.clearLoginData(session);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        session.setAttribute("username", username);

        if (!StringUtils.hasText(username)) {
            session.setAttribute("NotBlank_username", "NotBlank.userId");
        }

        if (!StringUtils.hasText(password)) {
            session.setAttribute("NotBlank_password", "NotBlank.password");
        }

        // 아이디, 비번이 있지만 실패한 경우 : 아이디로 조회되는 회원이 없거나, 비번이 일치 X
        if (StringUtils.hasText(username) && StringUtils.hasText(password)) {
            session.setAttribute("Global_error", "Fail.login");
        }

        //탈퇴회원
        if(exception instanceof DisabledException){
            session.setAttribute("Global_error", "Resign.member");
        }

        System.out.println("로그인 실패");
        // 로그인 페이지로 이동
        response.sendRedirect(request.getContextPath() + "/member/login");

    }
}