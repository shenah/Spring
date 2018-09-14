

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dao.GoodDao;
import dao.GoodDaoFactory;
import vo.GoodVO;

public class Main {

	public static void main(String[] args) {
		//Factory Method 패턴으로 인스턴스 생성 
		//GoodDao dao = GoodDaoFactory.create();
		
		//Spring의 어노테이션을 이용한 인스턴스 생성 
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GoodDaoFactory.class);
		GoodDao dao = context.getBean("create", GoodDao.class);
		System.out.println(dao);*/
		
		//Spring의 xml 파일설정을 이용한 인스턴스 생성 
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");// src/main/resources와 src/main/java는 실제 하나의 디렉토리
		GoodDao dao = context.getBean("goodDao", GoodDao.class);
		System.out.println(dao.hashCode());
		
		//해시코드 확인을 위한 인스턴스 생성 
		//확인 결과 singleton 패턴이 적용됨 
		dao = context.getBean("goodDao", GoodDao.class);
		System.out.println(dao.hashCode());
		
		context.close();
		
		List<GoodVO> list = dao.getGood();
		for(GoodVO vo : list) {
			System.out.println(vo);
		}

	}

}
