package com.oreilly.Project2.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.Project2.Model.Greeting;

@RestController
public class Project2Controller {
	
	@GetMapping("/hello")
	public Greeting sayHello(@RequestParam(required=false, defaultValue="World", value="name") String name, Model model) {
		return new Greeting("Hello "+name+" !!");
	}
	

}
