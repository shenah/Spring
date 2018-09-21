package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import vo.Dept;

public interface DeptMapper {
	
	@Select("select * from dept")
	public List<Dept> selectAll();
	
	@Insert("insert into dept values(#{deptno}, #{dname}, #{loc})")
	public int insertDept(Dept dept);
	
}
