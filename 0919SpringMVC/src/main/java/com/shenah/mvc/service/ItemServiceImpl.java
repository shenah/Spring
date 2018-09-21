package com.shenah.mvc.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shenah.mvc.dao.ItemDao;
import com.shenah.mvc.domain.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public List<Item> selectALL() {

		return itemDao.selectALL();
	}

	@Override
	public Item selectId(int itemid) {
		
		return itemDao.selectId(itemid);
	}



}
