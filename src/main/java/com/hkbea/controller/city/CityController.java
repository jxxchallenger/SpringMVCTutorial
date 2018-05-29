package com.hkbea.controller.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hkbea.domain.city.City;
import com.hkbea.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService;
	
	@GetMapping("/input")
	public String input(){
		
		return "city/input";
	}
	
	@PostMapping("/list")
	@ResponseBody
	public List<City> cityList(){
		
		return cityService.getAll();
	}
}
