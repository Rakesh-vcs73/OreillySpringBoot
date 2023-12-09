package com.oreilly.Project9.Service;

import org.springframework.stereotype.Service;

@Service
public class MapService {
	
	public String getURL(String lat, String lan) {
		
		//System.out.println("http://maps.google.com/maps?q="+lat+","+lan+"&ie=UTF8&iwloc=&output=embed");
		//return "https://nominatim.openstreetmap.org/ui/search.html?q=";
		return "https://nominatim.openstreetmap.org/ui/search.html?q="+lat+","+lan;
		//return lat+lan;
    
	}

}
