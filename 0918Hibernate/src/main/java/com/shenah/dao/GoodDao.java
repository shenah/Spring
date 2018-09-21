package com.shenah.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shenah.domain.Good;

@Repository
public class GoodDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	//데이터 삽입 메소드 
	public void insertGood(Good good) {
		 sessionFactory.getCurrentSession().save(good);
	}
	
	@Transactional
	//데이터 수정 메소드 
	public void updateGood(Good good) {
		 sessionFactory.getCurrentSession().update(good);
	}
	
	@Transactional
	//데이터 삭제 메소드 
	public void deleteGood(Good good) {
		 sessionFactory.getCurrentSession().delete(good);
	}
	
	@Transactional 
	//모든 데이터 가져오는 메소드  
	public List<Good> selectAll() {
		return sessionFactory.getCurrentSession().createCriteria(Good.class).list();
	}
	
	@Transactional
	//code로 조회하는 메소드 
	public Good get(int code) {
		return (Good)sessionFactory.getCurrentSession().get(Good.class, code);
	}
}
