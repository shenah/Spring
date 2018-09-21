package naver.shena.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller 클래스를 만들고 Bean을 자동생성하는 annotation
@Controller
public class DoController {

	//RequestMapping:웹의 요청 URL과 컨트롤러 클래스를 매핑 시켜주는 클래스
	@RequestMapping("hello.do")
	public String hello(Model model) {
		model.addAttribute("data", "Spring MVC");
		return "views/hello.jsp";//결과 페이지 이동, 기본 포워딩 
	}
	
	@RequestMapping("/archives/{num}")
	public String archive(@PathVariable int num, Model model) {
		model.addAttribute("data", num);
		return "../../views/archives.jsp";
	}
	
}
