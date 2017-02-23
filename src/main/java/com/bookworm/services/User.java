package com.bookworm.services;

public class User {
    private String firstName;
    private String lastName;
    private String title;
    private boolean male;
    private String email;
    private String location;
    private String phone;
    
    public User(){
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
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isMale() {
		return male;
	}
	
	public void setMale(boolean male) {
		this.male = male;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", title=" + title + ", male=" + male
				+ ", email=" + email + ", location=" + location + ", phone=" + phone + "]";
	}
	
}
