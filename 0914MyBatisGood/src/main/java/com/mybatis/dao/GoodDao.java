package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.domain.Goods;

@Repository
public class GoodDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Goods> selectAll(){
		return sqlSession.selectList("good.selectall");
	}
	
	public List<String> selectcol(){
		return sqlSession.selectList("good.col");
	}
	
	public Goods select(int code) {
		return sqlSession.selectOne("good.select", code);
	}

	public int insertGood(Goods good) {
		return sqlSession.insert("good.insertgood", good);
	}
	
}
