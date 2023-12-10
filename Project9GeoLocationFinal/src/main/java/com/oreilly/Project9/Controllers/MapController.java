package com.oreilly.Project9.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.oreilly.Project9.Model.Location;
import com.oreilly.Project9.Service.GeoService;
import com.oreilly.Project9.Service.MapService;

//Retained the comments to track the approaches taken to get it worked

@Controller
public class MapController {

	@Autowired
	public GeoService geoService;
	
	@Autowired
	public MapService mapService;
	
	
	@GetMapping("/showOnMap/{loc}")
	public String showOnMap(@PathVariable("loc") String searchLocation, Model model) throws Exception {
		Location[] location = geoService.getLocation(searchLocation);
		String urll = mapService.getURL(location[0].getLat(), location[0].getLon());
//		final URL myUrl = UriComponentsBuilder
//		        .fromHttpUrl(url)
//		        .build()
//		        .toUri()
//		        .toURL();
//		System.out.println(myUrl);
		model.addAttribute("urll", urll);
		//model.addAttribute("urll","https://nominatim.openstreetmap.org/ui/search.html?q=12.9767936,77.590082");
//		model.addAttribute("url1", "");
//		model.addAttribute("url2",location[0].getLat()+','+location[0].getLon());
		//model.addAttribute("urll", url+location[0].getLon()+','+location[0].getLon());
		return "map";
	}
	
	@GetMapping("/getMaps")
	public String showOnMaps(@RequestParam(value="locationString") String loc,Model model) throws Exception {
		Location location = geoService.saveLocationToDb(loc);
		//System.out.println(location);
		String urll = mapService.getURL(location.getLat(), location.getLon());
		model.addAttribute("urll", urll);
		List<Location> locations = geoService.getSavedLocationsService();
		//locations.forEach(System.out::println);
		model.addAttribute("locList",locations);
		return "map";
	}
	
	@GetMapping("/Home")
	public String searchHistory(Model model){
		List<Location> locations = geoService.getSavedLocationsService();
		//locations.forEach(System.out::println);
		model.addAttribute("locList",locations);
		return "Search";
		
	}
	
}
