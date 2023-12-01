package com.oreilly.Project2.Controller;

import com.oreilly.Project2.Model.Greeting;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTestWithServer {
	
	//Using TestRestTamplate from spring io docs
	@Test
    void testWithParameter(@Autowired TestRestTemplate restTemplate) throws Exception{
        Greeting response = restTemplate.getForObject("/hello?name=Dolly", Greeting.class);
        assertEquals("Hello Dolly !!",response.getMessage());
    }
	
	@Test
    void testWithOutParameter(@Autowired TestRestTemplate restTemplate) {
        ResponseEntity<Greeting> entity = restTemplate.getForEntity("/hello", Greeting.class);
        assertEquals(HttpStatus.OK,entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
        
        Greeting response = entity.getBody();
        assertEquals("Hello World !!", response.getMessage());
    }


}
