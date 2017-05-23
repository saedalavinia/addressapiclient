package me.alavinia.saed.pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
	
	private int sin; 
	private String firstName;
	private String lastName;
	private String pass;
	
	public Person(){}

	public Person(int sin, String firstName, String lastName, String pass) {
		//this.sin = Integer.parseInt(sin);
		this.sin = sin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pass = pass;
	}


	public int getSin() {
		return sin;
	}


	public void setSin(int sin) {
		this.sin = sin;
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


	@Override
	public String toString() {
		return this.getSin() + ":" + this.getFirstName() + " " +  this.getLastName();
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
}
