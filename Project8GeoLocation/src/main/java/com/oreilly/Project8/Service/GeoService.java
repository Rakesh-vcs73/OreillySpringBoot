package com.oreilly.Project8.Service;

import java.time.Duration;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.oreilly.Project8.Model.Location;

import reactor.core.publisher.Mono;

//using nominatim api as an alternative for geocoading API as it requires API key

@Service
public class GeoService {
	
	private final WebClient webClient;

    public GeoService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://nominatim.openstreetmap.org").build();
    }
    
    //Explore https://nominatim.org/release-docs/develop/api/Search/ to further modify the received data

    public Location[] getLocation(String searchLocation) {
    	
    	final String url = "https://nominatim.openstreetmap.org/search?format=json&addressdetails=1&limit=1&polygon_svg=0";
    	
    	UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("q", searchLocation);
    	//String finalUrl= builder.build().toString();
    	//System.out.println(finalUrl);
        return this.webClient.get().uri(builder.build().toUri()).retrieve().bodyToMono(Location[].class).block(Duration.ofSeconds(10));
    }

//	  Issue with below method is that it gets all the dat athat is fetched, instead of Location class.    
//    public List<Location> getLocation(String searchLocation) {
//    	
//    	final String url = "https://nominatim.openstreetmap.org/search?format=json";
//    	
//    	UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("q", searchLocation);
//    	//String finalUrl= builder.build().toString();
//    	//System.out.println(finalUrl);
//        List<Location> block = this.webClient.get().uri(builder.build().toUri()).retrieve().bodyToMono(List.class).block(Duration.ofSeconds(10));
//		return block;
//    }
    
    
    
}
