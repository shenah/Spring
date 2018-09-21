package com.shenah.mybatis.domain;

public class KTVVO {
	private String company;
	private String idnum;
	private String representative;
	private int room;
	private String phone;
	private String addr;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	public String getRepresentative() {
		return representative;
	}
	public void setRepresentative(String representative) {
		this.representative = representative;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "KTVVO [company=" + company + ", idnum=" + idnum + ", representative=" + representative + ", room="
				+ room + ", phone=" + phone + ", addr=" + addr + "]";
	}
	
	
	
	
}
