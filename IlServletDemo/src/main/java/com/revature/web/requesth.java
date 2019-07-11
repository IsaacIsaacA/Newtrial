package com.revature.web;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Movie;
import com.revature.service.MovieServiceImpl;
import com.revature.service.UserServiceImpl;

/*
 * Our Request is a class that returns objects to our Request Dispatcher Servlet.
 */
public class requesth {

	public static final Logger LOGGY = LogManager.getLogger(requesth.class);

	public static Object processGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		System.out.println("You made it");

		final String URI = req.getRequestURI().replace("/ServletDemo/getflixapi", "");

		switch (URI) {

		case "/movie/all":
			return new MovieServiceImpl().getAllMovies();

		default:
			return "RESOURCE NOT FOUND";
		}
	}

	public static Object processPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		System.out.println("you made it");
		final String URI = req.getRequestURI().replace("/ServletDemo/getflixapi", "");
		int k = 1;
		if (k == 1) {
			return new MovieServiceImpl().getAllMovies();
		}
		resp.sendRedirect("./links.html");
		resp.setStatus(200);

		switch (URI) {

		case "/login":
			if (new UserServiceImpl().isValidUser(req, resp)) {
				resp.setStatus(200);
				return "Login Successful";
			} else {
				resp.sendError(403);
				return "Login was not successful";
			}

		case "/movie/create":
			String body = req.getReader().lines().collect(Collectors.joining());
			Movie received = new ObjectMapper().readValue(body, Movie.class);
			LOGGY.info("The movie info is: " + received);
			/*
			 * This code should be refactored/moved to the service layer.
			 */
			return new MovieServiceImpl().insertMovie(req, resp);

		default:
			return "ENDPOINT NOT YET IMPLEMENTED";
		}

	}
}