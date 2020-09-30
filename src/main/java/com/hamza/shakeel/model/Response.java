package com.hamza.shakeel.model;

public class Response {
	private String status;
	private int numberOfUniqueEmailAddresses;
	private String message;
	
	public Response() {
		numberOfUniqueEmailAddresses=0;
	} 
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNumberOfUniqueEmailAddresses() {
		return numberOfUniqueEmailAddresses;
	}
	public void setNumberOfUniqueEmailAddresses(int numberOfUniqueEmailAddresses) {
		this.numberOfUniqueEmailAddresses = numberOfUniqueEmailAddresses;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
