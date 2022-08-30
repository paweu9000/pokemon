package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Assert.*;

@SpringBootTest
class PokemonApplicationTests {

	@Mock
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void mockNotNullTest() {
		Assert.assertNotNull(mockMvc);
	}

}
