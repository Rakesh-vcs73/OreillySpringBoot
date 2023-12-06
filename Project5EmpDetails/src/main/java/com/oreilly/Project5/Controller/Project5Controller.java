package com.oreilly.Project5.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.oreilly.Project5.Model.Results;
import com.oreilly.Project5.Service.Project5Service;


@RestController

public class Project5Controller {
	
	@Autowired
	Project5Service geoservice;
	
	@GetMapping("/getEmpDetails")
	public Results[] getlatlang() throws Exception{
		
		Results[] res = geoservice.getLatLng();
		return res;

	}
}
