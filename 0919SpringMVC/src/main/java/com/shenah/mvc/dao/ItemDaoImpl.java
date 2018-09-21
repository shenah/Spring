package com.shenah.mvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shenah.mvc.domain.Item;

@Repository
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Item> selectALL() {
		return sqlSession.selectList("item.selectAll");
	}

	@Override
	public Item selectId(int itemid) {
		return sqlSession.selectOne("item.selectId", itemid);
	}



}
