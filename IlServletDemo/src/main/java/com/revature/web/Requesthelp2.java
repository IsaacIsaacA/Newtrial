package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
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

public class Requesthelp2 {
	public static final Logger LOGGY = LogManager.getLogger(RequestHelper.class);

	public static Object processGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		final String URI = req.getRequestURI().replace("/ServletDemo/getflixapi", "");
		
		switch(URI) {
		
		case "/movie/all":
			return new MovieServiceImpl().getAllMovies();
			
		default:
			return "RESOURCE NOT FOUND";
		}
	}
	
public static Object processPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		final String URI = req.getRequestURI().replace("/ServletDemo/getflixa2pi", "");
		System.out.println(URI);
		System.out.println("You have arrived");
		
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		int numberofpeople=1;
		if(URI.equalsIgnoreCase("/loginer")){
			
			System.out.println("I have gone to the final destination");
			return "<a href=index.html>Visit W3Schools</a>";
		}
		if(numberofpeople==1) {
		System.out.println();
		resp.sendRedirect("<a href=\"./index.html\">Visit W3Schools</a>"); 
		
		}
		
		if(URI.equalsIgnoreCase("/loginer")){
			
			System.out.println("I have gone to the final destination");
		    resp.setContentType("text/html");
		    PrintWriter out = resp.getWriter();

		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Hola</title>");
		    out.println("</head>");
		    out.println("<body bgcolor=\"white\">");
		    out.println("</body>");
		    out.println("</html>");
		}
		
		switch(URI) {
		
		case "/login":
			if(new UserServiceImpl().isValidUser(req, resp)) {
				resp.setStatus(200);
				System.out.println("You got the results");
				return "Login Successful";
			}else {
				resp.sendError(403);
				return "Login was not successful";
			}
		
		case "/movie/create":
			String body = req.getReader().lines().collect(Collectors.joining());
			Movie received = new ObjectMapper().readValue(body, Movie.class);
			LOGGY.info("The movie info is: "+ received);
			/*
			 * This code should be refactored/moved to the service layer.
			 */
			return new MovieServiceImpl().insertMovie(req, resp);
			
		default:
			return "ENDPOINT NOT YET IMPLEMENTED";
		}
		
	}
}
