package com.kty.ex07;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

//@SpringBootTest
class Ex07ApplicationTests {

	@Test
	void contextLoads() {

		String[] arr = {"10입니다", "20입니다", "30입니다"};

		String res = Arrays.stream(arr)
				.reduce("", (s, s2) -> s + s2);
		System.out.println(res);
	}

}
