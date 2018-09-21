package com.shenah.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shenah.mybatis.domain.KTVVO;

@Repository
public class KTVDao {
	
	//@Autowired
	private SqlSession sqlsession;
	
	public List<KTVVO> selectAll(){
		return sqlsession.selectList("ktv.selectAll");
	}
	//없으면 null; 2개 이상이면 예외 발생 
	public KTVVO selectId(String idnum) {
		return sqlsession.selectOne("ktv.selectId", idnum);
	}
	
	public int insertktv(KTVVO vo) {
		return sqlsession.insert("ktv.insertktv", vo);
	}
	
	public int insertprocedure(KTVVO vo) {
		return sqlsession.insert("ktv.insertprocedure", vo);
	}
}
