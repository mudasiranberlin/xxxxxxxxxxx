package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {
	
	@Test
	public void testFindall(){
		
	}
	
	@Test
	public void testfindByName(){
		MovieService<Movie> mymovies =  new MovieService<Movie>();
		
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setLanguage("Kannada");
		m1.setTitle("A");
		m1.setYear(1998);
		m1.setRent(true);
		mymovies.create(m1);
		
		List<Movie> movietitle = new ArrayList<Movie>();
		movietitle.add(m1);
		
		List<Movie> findbyname = mymovies.findByName("a");
		Assert.assertEquals(movietitle, findbyname);
		
		
		
	}
	
	public void testfindByName_negate(){
		MovieService<Movie> mymovies =  new MovieService<Movie>();
		
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setLanguage("Kannada");
		m1.setTitle("A");
		m1.setYear(1998);
		m1.setRent(true);
		mymovies.create(m1);
		
		List<Movie> movietitle = new ArrayList<Movie>();
			
		List<Movie> findbyname = mymovies.findByName("zse");
		Assert.assertEquals(movietitle, findbyname);
		
		
		
	}

	@Test
	public void testcreate(){
		MovieService<Movie> mymovies =  new MovieService<Movie>();
		
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setLanguage("Kannada");
		m1.setTitle("A");
		m1.setYear(1998);
		m1.setRent(true);
		Movie t = mymovies.create(m1);
		
		Assert.assertEquals(m1, t );
		
	
	}

	@Test(expected=IllegalArgumentException.class)
	public void testcreate_duplicate(){
		MovieService<Movie> mymovies =  new MovieService<Movie>();
		
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setLanguage("Kannada");
		m1.setTitle("A");
		m1.setYear(1998);
		m1.setRent(true);
		mymovies.create(m1);
		
		Movie t = mymovies.create(m1);
		
	
	}
	@Test
	public void testupdate(){
		MovieService<Movie> mymovies =  new MovieService<Movie>();
		
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setLanguage("Kannada");
		m1.setTitle("A");
		m1.setYear(1998);
		m1.setRent(true);
		mymovies.create(m1);
		
		Movie m4 = new Movie();
		m4.setId(1);
		m4.setLanguage("Hindi");
		m4.setTitle("A");
		m4.setYear(1991);
		
		Movie t = mymovies.update(m4);
		
		Assert.assertEquals(m4, t);
	
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void testupdate_Illegal(){
		MovieService<Movie> mymovies =  new MovieService<Movie>();
		
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setLanguage("Kannada");
		m1.setTitle("A");
		m1.setYear(1998);
		m1.setRent(true);
		mymovies.create(m1);
		
		Movie m4 = new Movie();
		m4.setId(10);
		m4.setLanguage("Hindi");
		m4.setTitle("A");
		m4.setYear(1991);
		
		Movie t = mymovies.update(m4);
	}
	
	@Test
	public void testdelete(){
		
		MovieService<Movie> mymovies =  new MovieService<Movie>();
		
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setLanguage("Kannada");
		m1.setTitle("A");
		m1.setYear(1998);
		m1.setRent(true);
		mymovies.create(m1);
		
		
		Movie t = mymovies.delete(1);
		
		Assert.assertEquals(m1, t);
		
		
	
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void testdelete_illegal(){
		
		MovieService<Movie> mymovies =  new MovieService<Movie>();
		
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setLanguage("Kannada");
		m1.setTitle("A");
		m1.setYear(1998);
		m1.setRent(true);
		mymovies.create(m1);
		
		
		Movie t = mymovies.delete(10);
	}

	@Test
	public void testrentmovie(){
		MovieService<Movie> mymovies =  new MovieService<Movie>();
		
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setLanguage("Kannada");
		m1.setTitle("A");
		m1.setYear(1998);
		mymovies.create(m1);
		
		boolean t = mymovies.rentMovie(1, "DATTA");
		
		Assert.assertEquals(true, t);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testrentmovie_illegal(){
		MovieService<Movie> mymovies =  new MovieService<Movie>();
		
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setLanguage("Kannada");
		m1.setTitle("A");
		m1.setYear(1998);
		m1.setRent(true);
		mymovies.create(m1);
		
		boolean t = mymovies.rentMovie(1, "DATTA");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testrentmovie_illegal_2(){
		MovieService<Movie> mymovies =  new MovieService<Movie>();
		
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setLanguage("Kannada");
		m1.setTitle("A");
		m1.setYear(1998);
		m1.setRent(true);
		mymovies.create(m1);
		
		boolean t = mymovies.rentMovie(13, "DATTA");
		
	}

}
