package com.icia.member.dto;

public class MemberDTO {
	
	private String mname;
	private String maddr;
	private int mage;
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMaddr() {
		return maddr;
	}
	public void setMaddr(String maddr) {
		this.maddr = maddr;
	}
	public int getMage() {
		return mage;
	}
	public void setMage(int mage) {
		this.mage = mage;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [mname=" + mname + ", maddr=" + maddr + ", mage=" + mage + "]";
	}
						
}
