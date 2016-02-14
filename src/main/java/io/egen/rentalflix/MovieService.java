package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
	    List<Movie> movies=new ArrayList<Movie>();

		@Override
		public synchronized List<Movie> findAll() {
			// TODO Auto-generated method stub
	            List<Movie> mv=new ArrayList<Movie>();
	            if(!movies.isEmpty()){
	            for(Movie m:movies){
	                mv.add(m);
	            }  
	            }
			return mv;
		}

		@Override
		public synchronized List<Movie> findByName(String name) {
			// TODO Auto-generated method stub
	            List<Movie> mv=new ArrayList<Movie>();
	            for(Movie m:movies){
	                if(name.equalsIgnoreCase(m.getTitle())){
	                    mv.add(m);
	                }
	            }
			return mv;
		}

		@Override
		public synchronized Movie create(Movie movie) {
			// TODO Auto-generated method stub
	            UUID uid = UUID.randomUUID(); 
	            movie.setId(uid.toString());
	            movies.add(movie);
			return movie;
		}

		@Override
		public synchronized Movie update(Movie movie) {
			String s=movie.getTitle();
	                for(Movie m:movies){
	                if(s.equalsIgnoreCase(m.getTitle())){
	                    movies.remove(m);
	                    movies.add(movie);
	                }
	                else{
	                    try{
	                    throw new IllegalArgumentException("Threw an IllegalArgumentException");
	                        } catch(IllegalArgumentException e) {
	                            System.out.println("Caught an IllegalArgumentException..." + e.getMessage());
	                        }
	                }
	                }
			return movie;
		}

		@Override
		public synchronized Movie delete(String id) {
			Movie mov=null;
	                
	            for(Movie m:movies){
	                if(id.equalsIgnoreCase(m.getId())){
	                	mov=m;
	                    movies.remove(m);
	                }
	                else{
	                    try {
	                            throw new IllegalArgumentException("Threw an IllegalArgumentException");
	                        } catch(IllegalArgumentException e) {
	                            System.out.println("Caught an IllegalArgumentException..." + e.getMessage());
	                        }
	                }
	            }
			return mov;
		}

		@Override
		public synchronized boolean rentMovie(String movieId, String user) {
	            Map<ArrayList,String> rentissued=new HashMap<ArrayList,String>();
			for(Movie m:movies){
	                if(movieId.equalsIgnoreCase(m.getId())){
	                    if(m.isRented()){
	                    try {
	                            throw new IllegalArgumentException("Threw an IllegalArgumentException");
	                        } catch(IllegalArgumentException e) {
	                            System.out.println("Caught an IllegalArgumentException..." + e.getMessage());
	                        }
	                }
	                else{
	                    m.setRented(true);
	                    return true;
	                    
	                }
	                }
	                else{
	                    try {
	                            throw new IllegalArgumentException("Threw an IllegalArgumentException");
	                        } catch(IllegalArgumentException e) {
	                            System.out.println("Caught an IllegalArgumentException..." + e.getMessage());
	                        }
	                }
			
		}
	        return false;
	    }
	}
