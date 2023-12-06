package com.oreilly.Project5.Service;

import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import com.oreilly.Project5.Model.Results;

// Using https://hub.dummyapis.com/employee?noofRecords=10&idStarts=1001 as alternative to Google's geocoder, as its completely free

@Service
public class Project5Service {
	
		
		
		private final WebClient webClient;

		@Autowired
		public Project5Service( WebClient.Builder webClientBuilder) {
			
	        this.webClient = webClientBuilder.baseUrl("https://hub.dummyapis.com").build();
	    }

	    public Results[] getLatLng() {
	        return this.webClient.get().uri("/employee?noofRecords=10&idStarts=1001")
	        		.retrieve()
	        		.bodyToMono(Results[].class)
	        		.block(Duration.ofSeconds(2));
	        
	    }
	    
	    

}
