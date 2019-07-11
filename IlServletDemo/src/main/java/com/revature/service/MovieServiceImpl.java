package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Movie;
import com.revature.repository.MovieRepositoryImpl;

public class MovieServiceImpl implements MovieService{

	@Override
	public List<Movie> getAllMovies() {
		return new MovieRepositoryImpl().getAllMovies();
	}

	@Override
	public Movie insertMovie(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}
}
