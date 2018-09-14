import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//JUnit4를 이용해서 테스트를 수행한다는 설정 
@RunWith(SpringJUnit4ClassRunner.class)
//설정 파일을 실행해서 사용하는 성정 
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MyBatisTest {

	//동일한 자료형의 bean이 있으면 자동으로 주입하라는 어노테이션 
	//inject 대신에 Autowired 사용 가능 
	@Inject 
	private DataSource ds;
	
	@Test
	public void testConnection() {
		//java1.7버전부터 try()안에 구문을 쓰면 자동 close() 호출가능 
		//여러개 열거시 ; 사용
		try(Connection con = ds.getConnection()){
			System.out.println(con);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Inject
	private SqlSessionFactoryBean factoryBean;
	
	@Test
	public void print() {
		System.out.println("factorBean:" + factoryBean);
	}
}
