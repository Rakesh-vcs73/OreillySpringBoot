package com.oreilly.Project3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oreilly.Project3.Model.AstroResult;

//Service reads from the api to get astronauts

@Service
public class AstroService {
	
	private final RestTemplate template;

	@Autowired
	public AstroService(RestTemplateBuilder rtbuilder) {
		template=rtbuilder.build();
	}


	public AstroResult getAstros() {
		String url="http://api.open-notify.org/astros.json";
		return template.getForObject(url, AstroResult.class);
	}
	
	

}
