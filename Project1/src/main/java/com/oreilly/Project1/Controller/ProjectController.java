package com.oreilly.Project1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {
	
	@GetMapping("/hello")
	public String sayHello(@RequestParam(value="name", required=false, defaultValue="World") String name,Model model) {
		model.addAttribute("user", name);
		return "hello";
	}

}
