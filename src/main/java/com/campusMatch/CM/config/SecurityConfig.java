package com.campusMatch.CM.config;

import com.campusMatch.CM.user.handler.LoginFailureHandler;
import com.campusMatch.CM.user.handler.LoginSuccessHandler;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //csrf 사용 안함 (여기선 이 설정 필요한지 모르겠음 일단 주석)
        http.csrf(AbstractHttpConfigurer::disable);

        /* 로그인 페이지 설정 */
        //로그인 요청 /member/login [ post ]
        http.formLogin(f -> {
            f.loginPage("/member/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/member/loginProc")
                    .successHandler(new LoginSuccessHandler())
                    .failureHandler(new LoginFailureHandler());
        });

        http.logout(c -> {
            c.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                    .logoutSuccessUrl("/");
        });
        /* 인증 설정 E - 로그인, 로그아웃 */

        /* 인가 설정 S - 접근 통제 */
        // hasAuthority(..) hasAnyAuthority(...), hasRole, hasAnyRole
        // ROLE_롤명칭
        // hasAuthority('ADMIN')
        // ROLE_ADMIN -> hasAuthority('ROLE_ADMIN')
        // hasRole('ADMIN')
        http.authorizeHttpRequests(c -> {
            c/*.requestMatchers("/myPage/**", "/board/view/**", "/board/write/**").authenticated() // 회원 전용 -> 로그인 페이지로
                    .requestMatchers("/admin/**").hasAnyAuthority("ADMIN") //관리자 -> 401 에러
                    */
                    .anyRequest().permitAll(); // 그외 모든 페이지는 모두 접근 가능

        });

        //권한 없는 페이지 요청하면 예외처리 해주는 부분인듯?
        //관리자 페이지 무조건 401 뜨게 하는 장본인 인듯 이따 확인 필요
        http.exceptionHandling(c -> {
            c.authenticationEntryPoint((req, res, e) -> {
                String URL = req.getRequestURI();
                if (URL.indexOf("/admin") != -1) { // 관리자 페이지
                    res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                } else { // 회원전용 페이지
                    res.sendRedirect(req.getContextPath() + "/member/login");
                }

            });
        });
        /* 인가 설정 E - 접근 통제 */

/*
        //자동 로그인
        http.rememberMe(c -> {
            c.rememberMeParameter("autoLogin") // 자동 로그인으로 사용할 요청 파리미터 명, 기본값은 remember-me
                    .tokenValiditySeconds(60 * 60 * 24 * 30) // 로그인을 유지할 기간(30일로 설정), 기본값은 14일
                    .userDetailsService(memberInfoService) // 재로그인을 하기 위해서 인증을 위한 필요 UserDetailsService 구현 객체
                    .authenticationSuccessHandler(new LoginSuccessHandler()); // 자동 로그인 성공시 처리 Handler

        });
*/

        http.headers(c -> c.frameOptions(f -> f.sameOrigin()));

        return http.build();
    }



}
