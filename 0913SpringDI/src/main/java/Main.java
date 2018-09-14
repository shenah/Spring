
import org.springframework.context.support.GenericXmlApplicationContext;

import vo.CollectionBean;
import vo.Sample;

public class Main {

	public static void main(String[] args) {
		
		//Spring 컨테이너 실행하기 - 컨테이너 안에 있는 bean의 객체를 전부 생성합니다.
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		//Sample 객체 가져오기 
		//동일한 클래스로 만들어진 bean이 1개이면 아이디를 생략할 수 있습니다. 
		Sample sample = context.getBean(Sample.class);
		System.out.println(sample);
		
		//CollectionBean 객체 가져오기 
		CollectionBean cb = context.getBean(CollectionBean.class);
		for(String imsi : cb.getSet()) {
			System.out.println(imsi);
		}
		
		//map 출력 
		for(String key : cb.getMap().keySet()) {
			System.out.print(key + ": " + cb.getMap().get(key));
		}
		context.close();

	}

}
