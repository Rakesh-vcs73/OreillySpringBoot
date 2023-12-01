package com.oreilly.Project3.Service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oreilly.Project3.Model.AstroResult;
import com.oreilly.Project3.Model.Astros;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AstroServiceTest {
	
	@Autowired
	private AstroService service;
	
	@Test
	void getAstronaut() {
		AstroResult res = service.getAstros();
		int number = res.getNumber();
		String message=res.getMessage();
		List<Astros> people = res.getPeople();
		
		System.out.println("Number :"+ number);
		System.out.println("message: "+message);
		people.forEach(System.out::println);
		
		assertAll(
				()-> assertTrue(number>=0),
				()-> assertEquals(number,people.size())
				);
		
		
	}

}
