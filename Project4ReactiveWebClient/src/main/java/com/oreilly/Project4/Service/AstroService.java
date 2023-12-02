package com.oreilly.Project4.Service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.oreilly.Project4.Model.AstroResult;

import reactor.core.publisher.Mono;


@Service
public class AstroService {

	private final RestTemplate template;
	
	private final WebClient webClient;
	
    

	
	@Autowired
	public AstroService(RestTemplateBuilder rtBuilder,WebClient.Builder webClientBuilder) {
		this.template = rtBuilder.build();
		this.webClient = webClientBuilder.baseUrl("http://api.open-notify.org").build();
	}
	
	public AstroResult getAstrosUsingRestTamplate() {
		String url="http://api.open-notify.org/astros.json";
		return template.getForObject(url, AstroResult.class);
	}
	
	public AstroResult getAstrosUsingWebClient() {
        return this.webClient.get().uri("/astros.json").retrieve().bodyToMono(AstroResult.class).block(Duration.ofSeconds(1));
    }
	
	

}