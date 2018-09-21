package com.shen.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shen.view.service.MemberService;

@RestController
public class DataController {
	
	@RequestMapping(value="data.csv", method=RequestMethod.GET)
	public String dataCsv() {
		return "csv,xml,json";
	}
	
	@RequestMapping(value="data.json", method=RequestMethod.GET)
	public List<Map<String, String>> ajax() {
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
		
		return list;
	}
	
	@Autowired 
	private MemberService memberService; 
	
	@RequestMapping(value="idcheck", method=RequestMethod.GET)
	public Map<String, String> idCheck(@RequestParam("id") String id){
		String result = memberService.idCheck(id);
		Map<String, String> map = new HashMap<>();
		
		//아이디가 존재하지 않을 때 
		if(result == null) {
			map.put("result", "true");
		}else {
			map.put("result", "false");
		}
		
		return map;
	}
}
