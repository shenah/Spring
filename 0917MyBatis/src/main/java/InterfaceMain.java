import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.shenah.mybatis.dao.KTVInterface;
import com.shenah.mybatis.domain.KTVVO;

public class InterfaceMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		KTVInterface ktvInterface = context.getBean(KTVInterface.class);
		// 전체 데이터 가져오기
		List<KTVVO> list = ktvInterface.selectAll();
		for (KTVVO vo : list) {
			System.out.println(vo);
		}
		
		KTVVO vo = ktvInterface.selectId("948-48-2223");
		System.out.println(vo);
	}

}
