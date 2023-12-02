package com.oreilly.Project4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.Project4.Model.AstroResult;
import com.oreilly.Project4.Service.AstroService;

import reactor.core.publisher.Mono;

@RestController
public class Project4Controller {
	
	@Autowired
	public AstroService astroService;
	
	

	@GetMapping("/getUsingRestTemplate")
	public String getAstrosUsingRestTemplate() {
		AstroResult res = astroService.getAstrosUsingRestTamplate();
		System.out.println("INSIDE REST TEMPLATE REQUEST");
		System.out.println(res);
		return res.toString();
	}
	
	
	@GetMapping("/getUsingWebClient")
	public String getAstrosUsingWebClient() {
		AstroResult res = astroService.getAstrosUsingWebClient();
		System.out.println("INSIDE WEB CLIENT REQUEST");
		System.out.println(res);
		return res.toString();
	}
	
	
}
