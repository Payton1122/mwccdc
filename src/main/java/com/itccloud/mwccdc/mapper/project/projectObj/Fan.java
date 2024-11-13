package com.itccloud.mwccdc.mapper.project.projectObj;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Fan {

	private int fanId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String firstOccupation;
	private String preferredStand;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp reservationTime;
	
	
	public int getFanId() {
		return fanId;
	}
	
	public void setFanId(Integer fanId) {
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
	
	public String getFirstOccupation() {
		return firstOccupation;
	}
	
	public void setFirstOccupation(String firstOccupation) {
		this.firstOccupation = firstOccupation;
	}
	
	public String getPreferredStand() {
		return preferredStand;
	}
	
	public void setPreferredStand(String preferredStand) {
		this.preferredStand = preferredStand;
	}
	
	public Timestamp getReservationTime() {
		return reservationTime;
	}
	
	public void setReservationTime(Timestamp reservationTime) {
		this.reservationTime = reservationTime;
	}
	
	
}
