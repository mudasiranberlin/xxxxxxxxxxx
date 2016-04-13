package io.egen.rentalflix;

import java.util.List;

public class Tester {

	public static void main(String[] args) {
		MovieService<Movie> mymovies =  new MovieService<Movie>();
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setLanguage("Kannada");
		m1.setTitle("A");
		m1.setYear(1998);
		m1.setRent(true);
		mymovies.create(m1);
		
		Movie m2 = new Movie();
		m2.setId(2);
		m2.setLanguage("Kannada");
		m2.setTitle("UPENDRA");
		m2.setYear(2000);
		mymovies.create(m2);
		
		Movie m3 = new Movie();
		m3.setId(3);
		m3.setLanguage("Kannada");
		m3.setTitle("BomBaY");
		m3.setYear(2000);
		mymovies.create(m3);
		
		
		List<Movie> reterieveallmovies = mymovies.findAll();
		for (Movie temp : reterieveallmovies) {
			System.out.println("MOVIENAMEs : " + temp.getTitle());
			System.out.println("MOVIELANGUAGEs : " + temp.getLanguage());
			System.out.println("MOVIEYEAR : " + temp.getYear());
			System.out.println("RENT : " + temp.isRent());
		}

		System.out.println("________");
		Movie m4 = new Movie();
		m4.setId(2);
		m4.setLanguage("Hindi");
		m4.setTitle("KKHH");
		m4.setYear(1991);
		
		mymovies.update(m4);
		
		System.out.println("XXXXX = "+mymovies.rentMovie(200, "DATTA"));
		
		List<Movie> deletedmovies = mymovies.findAll();
		for (Movie temp : deletedmovies) {
			System.out.println("MOVIENAME : " + temp.getTitle());
			System.out.println("MOVIELANGUAGE : " + temp.getLanguage());
			System.out.println("MOVIEYEAR : " + temp.getYear());
			System.out.println("RENT : " + temp.isRent());
		}
		System.out.println("________");
		
		
		List<Movie> findbyname = mymovies.findByName("bombay");
		for (Movie temp : findbyname) {
			System.out.println("MOV : " + temp.getTitle());
		}
	}

}
