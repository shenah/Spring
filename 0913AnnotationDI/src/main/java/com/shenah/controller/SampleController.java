package com.shenah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shenah.service.SampleService;

@Controller
public class SampleController {
	
	@Autowired
	private SampleService sampleService;
	
	public String test() {
		return sampleService.test();
	}
}
