package com.shenah.view.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//xml 파일을 이용한 AOP 
@Component
//annotation을 이용한 AOP
@Aspect
public class LoggingAdvice {
	@Around("execution(* com.shenah.view.HomeController*.*(..))")
	//aop 동작할 메소드 - 예외가 발생하면 호출한 곳에서 처리하도록 설정 
	public Object invoke(ProceedingJoinPoint joinPoint )throws Throwable {
		System.out.println("메소드가 작업을 수행한 전에 수행합니다.");
		
		//원본 메소드 호출 
		Object obj = joinPoint.proceed();
		
		System.out.println("메소드가 작업을 수행한 후에 수행합니다.");
		return obj;
	}
}
