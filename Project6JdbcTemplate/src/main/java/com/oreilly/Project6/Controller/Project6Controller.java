package com.oreilly.Project6.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.Project6.Model.Officer;
import com.oreilly.Project6.Repo.OfficerRepoImpl;

@RestController
public class Project6Controller {
	
	@Autowired
	 public OfficerRepoImpl ori;
	
	@GetMapping("/getAll")
	public List<Officer> getOfficerById(){
		return ori.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Officer> getOfficerById(@PathVariable("id") int id){
		return ori.findById(id);
		
	}
	
	@GetMapping("/getCount")
	public Long getCount() {
		return ori.count();
	}
	
	@GetMapping("/check/{id}")
	public Boolean checkIfOfficerExists(@PathVariable("id") int id) {
		return ori.existsById(id);
	}

}
