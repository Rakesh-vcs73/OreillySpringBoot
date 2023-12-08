package com.oreilly.Project8.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.Project8.Model.Location;
import com.oreilly.Project8.Service.GeoService;

@RestController
public class GetLocationController {

	@Autowired
	private GeoService geoService;
	
	@GetMapping("/getLocation/{loc}")
	public Location[] getLocation(@PathVariable("loc") String searchLocation) {
		Location[] location = geoService.getLocation(searchLocation);
		//System.out.println(location[0].getDisplay_name());
		return location;
		
	}
}
