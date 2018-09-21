import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.shenah.dao.GoodDao;
import com.shenah.domain.Good;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		GoodDao dao = context.getBean(GoodDao.class);
		
		Good good = new Good(); 
		good.setCode(40);
		good.setName("귤");
		good.setPrice(10000);
		good.setDescription("한국");
		dao.deleteGood(good);
		
		List<Good> list = dao.selectAll();
		for(Good goods : list) {
			System.out.println(goods);
		}
		
		System.out.println(dao.get(30));
		context.close();
	}

}
