package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.GoodVO;

public class GoodDao {
	
	//Spring의 BeanFactory 사용 -  xml설정파일 
	//default 생성자는 패키지 내부에서만 사용할 수 있기에 public으로 설정 
	public GoodDao() {} 
	
	//전체 데이터를 읽어오는 메소드 
	//파라미터를 만들 때 insert 나 update는 vo 
	//delect는 primary key
	//select는 where 절에 대입되어야 하는 데이터 
	public List<GoodVO> getGood() {
		List<GoodVO> list= new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shenah?characterEncoding=UTF-8&serverTimezone=UTC", "root", "shenaihua");
			pstmt = con.prepareStatement("select * from goods");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodVO vo = new GoodVO();
				vo.setCode(rs.getInt("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setDescription(rs.getString("description"));
				list.add(vo);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			if(rs != null)
				try {
					rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (Exception e) {}
		}
		return list;
	}
}
