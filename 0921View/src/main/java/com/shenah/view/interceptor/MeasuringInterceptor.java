package com.shenah.view.interceptor;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//bean을 자동 생성해주는 어노테이션 
//bean의 id는 클래스 이름중에서 첫글자만 소문자로 변환 
@Component
public class MeasuringInterceptor implements HandlerInterceptor {
	
	long start;
	//Controller가 요청을 처리하기 전에 실행 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("컨트롤러 실행");
		start = System.currentTimeMillis();
		
		//어디(ip)에서 언제 서비스를 사용했는지 파일에 기록 
		
		//오늘 날짜 기록 
		Calendar cal = Calendar.getInstance();
		Date date = new Date(cal.getTimeInMillis());

		try(FileOutputStream fos = new FileOutputStream("/Users/a503-03/Documents/logs/" + date.toString() + ".txt", true); PrintWriter pw = new PrintWriter(fos);){
			System.out.println(pw);
			String ip = request.getRemoteAddr();
			String msg = String.format("%04d%02d%02d%02d%02d%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 
					cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
			pw.println(ip + " - " + msg); 
		}
		
		//false를 리턴하면 Controller가 작동하지 않는다. 
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			System.out.println("뷰로 가기전에 호출");
		
	}
	
	//예외발생 여부와 상관없이 Controller 작
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		long end = System.currentTimeMillis();
		System.out.println(request.getRequestURI() + " 실행 시간: " + (end - start));
		
		
	}

}
