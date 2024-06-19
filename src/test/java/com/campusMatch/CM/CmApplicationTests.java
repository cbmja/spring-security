package com.campusMatch.CM;

import com.campusMatch.CM.user.entity.Member;
import com.campusMatch.CM.user.service.JoinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class CmApplicationTests {

	@Autowired
	private JoinService joinService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {

		Member member1 = new Member();
		member1.setEmail("user@naber.com");
		member1.setPassword("1234");
		member1.setUserId("user");

		Member member2 = new Member();
		member2.setEmail("admin@naber.com");
		member2.setPassword("1234");
		member2.setUserId("admin");

		joinService.process(member1);
		joinService.process(member2);
		String check =
		passwordEncoder.matches("1234" , "$2a$10$Rm7t2a3UP0a4cLPBQiVOIuiYDn5vZ3E.9Du7WsZvGOSNIZGfC3Zp2")
				? "t" : "f";

	}

}
