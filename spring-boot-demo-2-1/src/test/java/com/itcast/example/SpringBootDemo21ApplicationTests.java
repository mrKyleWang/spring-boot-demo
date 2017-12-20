package com.itcast.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.itcast.example.controller.IndexController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo21ApplicationTests {
	
	
	private MockMvc mvc;
	
	
	@Before
	public void before() {
		this.mvc=MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}

	@Test
	public void contextLoads() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/index");
		mvc.perform(req).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("hello world"));
	}

}
