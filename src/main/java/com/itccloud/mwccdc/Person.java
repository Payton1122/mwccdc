package com.itccloud.mwccdc;


public class Person {
	
	
	private String firstName;
	private String lastName;
	private String gender;
	
	
	public Person(String firstName, String lastName, String gender) {
		
		this.firstName = firstName;
		this.lastName = lastName; 
		this.gender = gender;
		
	}

	//First Name
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//Last Name
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//Gender
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	@Override 
	public String toString() {
		
		StringBuilder personBuild = new StringBuilder();
		personBuild.append(firstName).append(", ")
			.append(lastName).append(", ")
			.append(gender).append(", ");
		
		return personBuild.toString();
	}
	
}

