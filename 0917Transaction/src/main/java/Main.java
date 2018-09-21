import org.springframework.context.support.GenericXmlApplicationContext;

import dao.DeptMapper;
import service.DeptService;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		DeptService service= context.getBean(DeptService.class);
		
		service.insertdept();
		
		context.close();

	}

}
