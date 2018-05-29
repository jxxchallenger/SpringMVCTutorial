package com.hkbea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EnvironmentController implements EnvironmentAware {

	private Environment environment;
	
	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;

	}
	
	@RequestMapping(value="/environment")
	@ResponseBody
	public List<String> showEnvironment(){
		
		List<String> profiles = new ArrayList<String>();
		profiles.addAll(Arrays.asList(environment.getDefaultProfiles()));
		return profiles;
	}

}
