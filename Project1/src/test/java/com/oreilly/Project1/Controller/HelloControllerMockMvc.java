package com.oreilly.Project1.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(ProjectController.class)
public class HelloControllerMockMvc {

	//https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/#features.testing.spring-boot-applications.spring-mvc-tests
	
	@Autowired
    private MockMvc mvc;
	
	
	@Test
	public void autowiringWorked() {
		assertNotNull(mvc);
	}
	
	@Test
	public void testHelloWithoutParam() throws Exception{
		mvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
		.andExpect(status().isOk())
		.andExpect(view().name("hello"))
		.andExpect(model().attribute("user", "World"));
		System.out.println("Rock ---------------");
		
	}
	
	@Test
	public void testHelloWithParam() throws Exception {
		mvc.perform(get("/hello").param("name", "rakesh").accept(MediaType.TEXT_HTML))
		.andExpect(status().isOk())
		.andExpect(view().name("hello"))
		.andExpect(model().attribute("user", "rakesh"));
		
	}
	
	
	
}
