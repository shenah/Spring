package naver.shenah.mvc;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import naver.shenah.mvc.vo.Article;


@Controller
public class HomeController {
	
	//시작 요청이 왔을때 시작페이지 home.jsp로 이동 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {			
		return "home";
	}
	
	//input 요청이 왔을 때 처리하는 메소드 
	@RequestMapping(value="input",  method=RequestMethod.GET)
	public String input(Model model) {
		//여기서 리턴한 뷰 이름을 가지고 servlet-context.xml로 가서 실제 출력할 뷰파일 결정 
		return "article";
	}
	
	//파라미터 읽는 방법1: HttpServletRequest
	/*@RequestMapping(value="input", method=RequestMethod.POST)
	public String input(HttpServletRequest request, Model model) {
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println("제목:" + subject);
		System.out.println("내용:" + content);
		
		return "";
	}*/
	
	//파라미터 읽는 방법2: @RequestParam
	/*@RequestMapping(value="input", method=RequestMethod.POST)
	public String input(@RequestParam("subject") String subject,
						@RequestParam("content") String content,
						Model model) {
		System.out.println("제목:" + subject);
		System.out.println("내용:" + content);
		return "";
	}*/
	
	//파라미터 읽는 방법3: Command 객체 
	@RequestMapping(value="input", method=RequestMethod.POST)
	public String input(Article article, Model model, HttpSession session, RedirectAttributes attr) {

		model.addAttribute("model", article);
		session.setAttribute("session", article);
		attr.addFlashAttribute("attr", article);
	
		return "redirect:result";
	}
	
	//result 요청이 왔을 때 처리하는 메소드 
	@RequestMapping(value="result", method=RequestMethod.GET)
	public String result(Model model) {
		return "result";
	}
}
