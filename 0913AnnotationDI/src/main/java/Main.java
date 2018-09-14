import org.springframework.context.support.GenericXmlApplicationContext;

import com.shenah.controller.SampleController;
import com.shenah.dao.SampleDao;
import com.shenah.service.SampleService;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		SampleDao dao = context.getBean(SampleDao.class);
		System.out.println(dao.test());
		
		SampleService service = context.getBean(SampleService.class);
		System.out.println(service.test());
		
		SampleController controller = context.getBean(SampleController.class);
		System.out.println(controller.test());
		
		context.close();

	}

}
