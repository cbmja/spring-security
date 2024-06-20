package com.campusMatch.CM;

import com.campusMatch.CM.board.entity.BoardData;
import com.campusMatch.CM.board.service.BoardSaveService;
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

	@Autowired
	private BoardSaveService boardSaveService;

	@Test
	void contextLoads() {



		for(int i=0; i<100; i++){
			BoardData b = new BoardData();
			b.setType("notice");
			b.setContent(i+"");
			b.setTitle(i+"");

			boardSaveService.save(b);
		}


	}

}
