package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.internal.runners.model.EachTestNotifier;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 * @param <E>
 */
public class MovieService<E> implements IFlix {
	List<Movie> moviestore = new ArrayList<Movie>();
	@Override
	public List<Movie> findAll() {
		List<Movie> allmovies = new ArrayList<Movie>();
		for (Movie temp : moviestore) {
			allmovies.add((temp));
		}
		return allmovies;
	}

	@Override
	public List<Movie> findByName(String name) {
		// TODO Auto-generated method stub
		List<Movie> movietitle = new ArrayList<Movie>();
		for (Movie temp : moviestore) {
			if(temp.getTitle().equalsIgnoreCase(name))
			{
				movietitle.add(temp);
			}
		}
		return movietitle;
	}

	@Override
	public Movie create(Movie movie) {
		// TODO Auto-generated method stub
		int flag = 0;
		for (Movie temp : moviestore) {
			if(movie.getId() == temp.getId())
			{
				flag = 1;
			}
		}
		if(flag==0)
		{
			moviestore.add(movie);	
			return movie;
		}
		else throw new IllegalArgumentException("MOVIE ALREADY EXISTS BY THIS ID");
		
	}

	@Override
	public Movie update(Movie movie) {
		// TODO Auto-generated method stub
		Movie temp_movie = null;
		int flag = 0;
		for (Movie temp : moviestore) {
			if(temp.getId() == movie.getId())
			{
				temp_movie = temp;
				flag = 1;
			}
		}
		
		if(flag == 1)
		{
			moviestore.remove(temp_movie);
			moviestore.add(movie);
			return movie;
		}
		else throw new IllegalArgumentException("MOVIE ID DOES NOT EXISTS");

	}

	@Override
	public Movie delete(int id) {
		// TODO Auto-generated method stub
		Movie temp_movie = null;
		int flag = 0;
		for (Movie temp : moviestore) {
			if(id == temp.getId())
			{
				temp_movie = temp;
				flag = 1;
			}
		}
		
		if (flag == 0)
		{
			throw new IllegalArgumentException("NO MOVIE BY THIS NAME IS PRESENT");
		}
		
		else{
			moviestore.remove(temp_movie);
			return temp_movie;
		}
		
	}

	@Override
	public boolean rentMovie(int movieId, String user) {
		// TODO Auto-generated method stub
		int moviepresentflag = 0;
		for (Movie temp : moviestore) {
			if(movieId == temp.getId())
			{
				moviepresentflag = 1;
				if(temp.isRent()){
					throw new IllegalArgumentException("THE MOVIE IS ALREADY RENTED");
					
				}
				else{
					temp.setRent(true);
					return true;
				}
			}
		}
		
		if(moviepresentflag == 0){
			throw new IllegalArgumentException("THE MOVIE ID GIVEN IS NOT IN THE MOVIE STORE");
		}
		return false;
	}

}
