package com.shenah.mvc.service;

import java.util.List;


import com.shenah.mvc.domain.Item;

public interface ItemService {

	//전체 데이터 가져오는 메소드 
	public List<Item> selectALL();
	
	//상세보기 데이터 가져오는 메소드 
	public Item selectId(int itemid);

}
