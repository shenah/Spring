import org.springframework.context.support.GenericXmlApplicationContext;

import com.mybatis.dao.GoodDao;
import com.mybatis.domain.Goods;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		GoodDao dao = context.getBean(GoodDao.class);
		
		//전체 데이터 읽어오기 
		for(Goods good : dao.selectAll()) {
			System.out.println(good);
		}
		//1개 컬럼을 전부 읽어오
		for(String name : dao.selectcol()) {
			System.out.println(name);
		}
		
		//특정 데이터 읽어오기 
		System.out.println(dao.select(1));
		
		//데이터 insert 
		Goods good = new Goods();
		good.setCode(30);
		good.setName("복숭아");
		good.setPrice(20000);
		good.setDescription("한국");
		System.out.println(dao.insertGood(good));
		context.close();
	}

}
