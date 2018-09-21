package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DeptMapper;
import vo.Dept;

@Service
public class DeptService {

	@Autowired
	private DeptMapper deptMapper;
	
	@Transactional
	public void insertdept() {
		Dept dept = new Dept();
		dept.setDeptno(80);
		dept.setDname("영업");
		dept.setLoc("서울");
		
		deptMapper.insertDept(dept);
		deptMapper.insertDept(dept);
	}
}
