package com.oreilly.Project9.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.Project9.Model.Location;
import com.oreilly.Project9.Service.GeoService;

@RestController
public class GetLocationController {

	@Autowired
	public GeoService geoService;
	
	
	@GetMapping("/getLocation/{loc}")
	public Location[] getLocation(@PathVariable("loc") String searchLocation) {
		Location[] location = geoService.getLocation(searchLocation);
		//System.out.println(location[0].getDisplay_name());
		return location;
		
	}
	
	@PostMapping("/saveLocation/{loc}")
	public Location saveLocation(@PathVariable("loc") String searchLocation) {
		return geoService.saveLocationToDb(searchLocation);
	}
	
	@GetMapping("/getSavedLocations")
	public List<Location> getSavedLocations(){
		return geoService.getSavedLocationsService();
	}
	
}
