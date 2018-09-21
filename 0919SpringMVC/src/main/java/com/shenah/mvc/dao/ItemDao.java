package com.shenah.mvc.dao;

import java.util.List;

import com.shenah.mvc.domain.Item;

public interface ItemDao {

	//전체 데이터 가져오는 메소드 
	public List<Item> selectALL();
	
	//데이터 상세보기를 위한 메소드 
	public Item selectId(int itemid);
	

}
