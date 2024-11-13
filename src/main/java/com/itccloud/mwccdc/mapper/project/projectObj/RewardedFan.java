package com.itccloud.mwccdc.mapper.project.projectObj;

public class RewardedFan {

	private int fanId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String standPosition;
	private String seatNumber;
	
	public int getFanId() {
		return fanId;
	}
	
	public void setFanId(int fanId) {
		this.fanId = fanId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getStandPosition() {
		return standPosition;
	}
	
	public void setStandPosition(String preferredStand) {
		this.standPosition = preferredStand;
	}
	
	public String getSeatNumber() {
		return seatNumber;
	}
	
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
}
