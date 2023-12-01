package com.oreilly.Project3.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.Project3.Model.AstroResult;
import com.oreilly.Project3.Model.Astros;
import com.oreilly.Project3.Service.AstroService;

//@RestController
@Controller
public class Project3Controller {
	
	@Autowired
	private AstroService asr;

	@GetMapping("/AstroJson")
	public AstroResult Result() {
		return asr.getAstros();
		
	}
	
	@GetMapping("/AstroTable")
	public String getresult(Model model) {
		AstroResult resultForTable = asr.getAstros();
		model.addAttribute("res",resultForTable);
		List<Astros> AstroList = resultForTable.getPeople();
		AstroList.forEach(System.out::println);
		model.addAttribute("AstroList", AstroList);
		return "hello";
		
	}
}
