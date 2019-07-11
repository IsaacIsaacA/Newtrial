package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Movie;

public interface MovieService {

	List<Movie> getAllMovies();
	Movie insertMovie(HttpServletRequest req, HttpServletResponse resp);
}
