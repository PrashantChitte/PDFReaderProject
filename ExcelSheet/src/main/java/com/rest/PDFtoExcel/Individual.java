package com.rest.PDFtoExcel;

public class Individual {
	private String firstName;
	private String middleName;
	private String lastName;
	private String faterName;
	private String anyExperience;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFaterName() {
		return faterName;
	}
	public void setFaterName(String faterName) {
		this.faterName = faterName;
	}
	public String getAnyExperience() {
		return anyExperience;
	}
	public void setAnyExperience(String anyExperience) {
		this.anyExperience = anyExperience;
	}
	public Individual(String firstName, String middleName, String lastName,
			String faterName, String anyExperience) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.faterName = faterName;
		this.anyExperience = anyExperience;
	}
	public Individual() {
		super();
	}
	@Override
	public String toString() {
		return "Individual [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", faterName=" + faterName + ", anyExperience=" + anyExperience + "]";
	}
	

}
