package com.shen.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value="excel.xls", method=RequestMethod.GET)
	public String excel(Model model) {
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("javascript");
		list.add("c");
		list.add("c++");
		list.add("python");
		list.add("R");
		list.add("Swift");
		
		model.addAttribute("list",list);
		return "programming";

	}
	
	@RequestMapping(value="data.pdf", method=RequestMethod.GET)
	public String pdf(Model model) {
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("javascript");
		list.add("c");
		list.add("c++");
		list.add("python");
		list.add("R");
		list.add("Swift");
		
		model.addAttribute("list",list);
		return "programming language";

	}
	
	@RequestMapping(value="jsonview.json", method=RequestMethod.GET)
	public String jsonview(Model model) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		map.put("name", "제니");
		map.put("phone", "01094875754");
		list.add(map);
		
		map = new HashMap<>();
		map.put("name", "로제");
		map.put("phone", "01097557404");
		list.add(map);
		
		map = new HashMap<>();
		map.put("name", "지수");
		map.put("phone", "01004736494");
		list.add(map);
		
		map = new HashMap<>();
		map.put("name", "리사");
		map.put("phone", "01063749505");
		list.add(map);
		
		model.addAttribute("list", list);
		
		return "jsonview";
	}

	
}
