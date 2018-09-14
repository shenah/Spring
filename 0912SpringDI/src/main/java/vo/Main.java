package vo;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//Spring 설정 파일의 내용 가져오기 
		//lazy-init 설정이 없으면 person 객체가 처음부터 만들어짐  
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("1");
		//id가 person인 객체 가져오기 
		//lazy-init true로 설정하면 person이 사용될 때 생성 
		Person person = context.getBean("person", Person.class);
		System.out.println("2");
		
		System.out.println(person);
		System.out.println("3");
		
		context.close();

	}

}
