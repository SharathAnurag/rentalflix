package io.egen.rentalflix;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {

	 @Test
	    public void testCreate(){
	        MovieService ms=new MovieService();
	        Movie mv=new Movie("SkyFall",2012,"English",false);
	        Movie actual=ms.create(mv);
	        Assert.assertEquals(mv.getTitle(), actual.getTitle());
	    }
	    
	    @Test
	    public void testFindAll(){
	        MovieService ms=new MovieService();
	        Movie mv=new Movie("SkyFall",2012,"English",false);
	        Movie m=ms.create(mv);
	        List<Movie> ls=ms.findAll();
	        Assert.assertEquals(1, ls.size());
	    }
	    
	    @Test
	    public void testFind(){
	    	MovieService ms=new MovieService();
	    	Movie mv=new Movie("SkyFall",2012,"English",false);
	        Movie m=ms.create(mv);
	    	List<Movie> ls=ms.findByName("SkyFall");
	    	Assert.assertEquals(1, ls.size());
	    }
	    
	    @Test
	    public void testUpdate(){
	        MovieService ms=new MovieService();
	        Movie mv=new Movie("SkyFall",2014,"French",false);
	        Movie Actual=ms.update(mv);
	        Assert.assertEquals(mv, Actual);
	    }
	    @Test(expected = IllegalArgumentException.class)
	    public void testDelete(){
	        MovieService ms=new MovieService();
	        Movie mv=new Movie("Skyfall",2014,"French",false);
	        Movie Actual=ms.delete(mv.getId());
	        Assert.assertEquals(mv,Actual);
	    }
	    @Test(expected = IllegalArgumentException.class)
	    public void testRent(){
	        MovieService ms=new MovieService();
	        boolean b=ms.rentMovie("dasdsa", "sharath");
	        Assert.assertEquals(true, b);
	    }
	    
	    
	}