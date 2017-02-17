package com.example.Book;

public class Book {
	
	private int id;
	private String title = "";
	private String firstName = "";
	private String lastName = "";
	private int isbn;
	private String category = "";
	
	
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
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



	public int getIsbn() {
		return isbn;
	}



	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + ", isbn="
				+ isbn + ", category=" + category + "]";
	}

	
}
