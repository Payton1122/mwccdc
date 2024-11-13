package com.itccloud.mwccdc.mapper.project.projectObj;

public class Stand {

	private String standPosition;
	private int availableSeats;
	private int preferredSeat;
	private float discountPPTicket;
	private float estTotalEarnings;
	
	
	public String getStandPosition() {
		return standPosition;
	}
	
	public void setStandPosition(String standPosition) {
		this.standPosition = standPosition;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public int getPreferredSeat() {
		return preferredSeat;
	}
	
	public void setPreferredSeat(int preferredSeat) {
		this.preferredSeat = preferredSeat;
	}
	
	public float getDiscountPPTicket() {
		return discountPPTicket;
	}
	
	public void setDiscountPPTicket(float discountPPTicket) {
		this.discountPPTicket = discountPPTicket;
	}
	
	public float getEstTotalEarnings() {
		return estTotalEarnings;
	}
	
	public void setEstTotalEarnings(float estTotalEarnings) {
		this.estTotalEarnings = estTotalEarnings;
	}
	
}
