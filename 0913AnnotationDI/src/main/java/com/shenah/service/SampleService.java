package com.shenah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shenah.dao.SampleDao;

@Service
public class SampleService {
	
	@Autowired
	private SampleDao sampleDao;
	
	public String test() {
		return sampleDao.test();
	}

}
