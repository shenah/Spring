package com.shenah.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.shenah.mybatis.domain.KTVVO;

public interface KTVInterface {
	@Select("select * from ktv")
	public List<KTVVO> selectAll();
	
	@Select("select * from ktv where idnum = #{idnum}")
	public KTVVO selectId(String idnum);
	
	@Insert("insert into ktv values(#{company}, #{idnum}, #{representative}, #{room}, #{phone}, #{addr})")
	public int insertktv(KTVVO vo);
	
	@Insert("call insertktv(#{company}, #{idnum}, #{representative}, #{room}, #{phone}, #{addr})")
	public int insertprocedure(KTVVO vo);
			
}
