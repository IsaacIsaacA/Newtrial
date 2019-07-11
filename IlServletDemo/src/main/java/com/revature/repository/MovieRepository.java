package com.revature.repository;

import java.util.List;

import com.revature.model.Movie;

public interface MovieRepository {

	List<Movie> getAllMovies();
	void insertMovie(Movie m);
}
