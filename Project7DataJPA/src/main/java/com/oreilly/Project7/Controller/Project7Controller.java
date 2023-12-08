package com.oreilly.Project7.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.Project7.Repository.OfficerRepo;

@RestController
public class Project7Controller {
	
	//Used Just to debugging as API only aims at testing the functionality of Repository implemented using JpaRepository
	
	@Autowired
	private OfficerRepo repo;
	
	@GetMapping("/hello")
	public String getcount() {
		System.out.println(repo.findAll());
		return repo.findById(1).toString();
	}

}
