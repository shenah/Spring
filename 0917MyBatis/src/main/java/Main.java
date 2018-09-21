import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.shenah.mybatis.dao.KTVDao;
import com.shenah.mybatis.domain.KTVVO;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		KTVDao dao = context.getBean(KTVDao.class);
		//전체 데이터 가져오기 
		List<KTVVO> list = dao.selectAll();
		for(KTVVO vo : list) {
			System.out.println(vo);
		}
		
		// idnum로 검색한 결과 가져오기  
//		KTVVO vo = dao.selectId("384-49-49855");
//		System.out.println(vo);
		
		
//		Scanner sc = new Scanner(System.in);
//		//primary key를 입력받는 경우에는 반드시 중복체크를 해야 합니다. 
//		String idnum = "";
//		while(true) {
//			System.out.println("사용할 사업자등록번호를 입력하세요");
//			idnum = sc.nextLine();
//			KTVVO vo = dao.selectId(idnum);
//			if(vo == null) {
//				System.out.println(idnum + "는 사용 가능한 사업자등록번호입니다.");
//				break;
//			}
//			System.out.println(idnum + "는 사용 불가능한 사업자등록번호입니다.");
//		}
//		
//		System.out.println("사업자명을 입력하세요.");
//		String company = sc.nextLine();
//		System.out.println("사업자 대표이름을 입력하세요.");
//		String representative = sc.nextLine();
//		System.out.println("전화번호를 입력하세요.");
//		String phone = sc.nextLine();
//		System.out.println("사업장 주소를 입력하세요.");
//		String addr = sc.nextLine();
//		
//		System.out.println("방 개수를 입력하세요.");
//		int room = sc.nextInt();
//		
//		sc.close();
//		KTVVO vo1 = new KTVVO();
//		vo1.setCompany(company);
//		vo1.setIdnum(idnum);
//		vo1.setRepresentative(representative);
//		vo1.setRoom(room);
//		vo1.setPhone(phone);
//		vo1.setAddr(addr);
//		
//		//int r = dao.insertktv(vo1);
//		int r = dao.insertprocedure(vo1);
//		System.out.println(r);
		
		context.close();
	}

}
