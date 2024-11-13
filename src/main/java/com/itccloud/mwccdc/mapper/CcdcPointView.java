package com.itccloud.mwccdc.mapper;

import java.time.LocalDate;

public class CcdcPointView {
	
	private LocalDate tDate;
	private String tDesc;
	private String tName;
	private String tType;
	private String uName;
	private float score; 
	private String remark;
	
	
	public LocalDate gettDate() {
		return tDate;
	}
	public void settDate(LocalDate tDate) {
		this.tDate = tDate;
	}
	public String gettDesc() {
		return tDesc;
	}
	public void settDesc(String tDesc) {
		this.tDesc = tDesc;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettType() {
		return tType;
	}
	public void settType(String tType) {
		this.tType = tType;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
