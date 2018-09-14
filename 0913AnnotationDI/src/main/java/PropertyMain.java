
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class PropertyMain {

	public static void main(String[] args) {
		//시스템 프로퍼티를 읽을 수 있는 객체를 생성 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		ConfigurableEnvironment env = context.getEnvironment();
		
		System.out.println("Path:" + env.getProperty("Path"));
		System.out.println("Java Version:" + env.getProperty("java.version"));
		System.out.println("Java Home:" + env.getProperty("java.home"));
		System.out.println("OS Name:" + env.getProperty("os.name"));
		System.out.println("OS version:" + env.getProperty("os.version"));
		
		//프로퍼티 파일 읽기 
		MutablePropertySources source = env.getPropertySources();
		
		//프로퍼티 파일 경로를 추가
		try {
			source.addLast(new ResourcePropertySource("classpath:db.properties"));
			System.out.println(env.getProperty("url"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		context.close();
		
		
	}

}
