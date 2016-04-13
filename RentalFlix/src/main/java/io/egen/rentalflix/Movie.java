package io.egen.rentalflix;


/**
 * Entity representing a movie.
 * Fields: id, title, year, language
 */
public class Movie {
	private int id;
	private String title;
	private Integer year;
	private String language;
	private boolean rent;
	//POJO IMPLEMENTATION GOES HERE
	
	public int getId() {
		return id;
	}
	public boolean isRent() {
		return rent;
	}
	public void setRent(boolean rent) {
		this.rent = rent;
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
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
