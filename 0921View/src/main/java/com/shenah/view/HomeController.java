package com.shenah.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shenah.view.domain.Command;
import com.shenah.view.domain.DataReport;
import com.shenah.view.domain.DataStructure;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}

	@RequestMapping(value = "data.xml", method = RequestMethod.GET)
	public String data(Model model) {
		DataStructure ds1 = new DataStructure();
		ds1.setName("list");
		ds1.setContent("데이터를 순서대로 저장");

		DataStructure ds2 = new DataStructure();
		ds2.setName("set");
		ds2.setContent("데이터를 중복없이 해싱을 이용해서 저장");

		DataStructure ds3 = new DataStructure();
		ds3.setName("map");
		ds3.setContent("키와 값을 쌍으로 저장");

		List<DataStructure> list = new ArrayList<>();
		list.add(ds1);
		list.add(ds2);
		list.add(ds3);

		DataReport dr = new DataReport();
		dr.setList(list);
		// 위의 데이터를 모델에 저장
		model.addAttribute("dataReport", dr);
		return "dataxml";
	}

	@RequestMapping(value = "interceptor", method = RequestMethod.GET)
	public String interceptor() {
		long start = System.currentTimeMillis();
		int sum = 0;
		for (int i = 1; i <= 100000000; i = i + 1) {
			sum = sum + i;
		}
		long end = System.currentTimeMillis();

		System.out.println(end - start);
		return "";
	}
	@RequestMapping(value = "fileupload", method = RequestMethod.GET)
	public String fileupload(Model model) {

		return "fileupload";
	}
	@RequestMapping(value = "fileupload", method = RequestMethod.POST)
	public String form(Command command, Model model) {
		System.out.println("이름:" + command.getName());
		
		if(command.getReport().isEmpty()){
			System.out.println("업로드한 파일이 없습니다.");
		}else {
			String filepath = "/Users/a503-03/Documents/fileupload/";
			filepath += UUID.randomUUID() + command.getReport().getOriginalFilename();
			try {
				command.getReport().transferTo(new File(filepath));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("파일 업로드 성공");
		}
		
		return "redirect: ./";
	}

}
