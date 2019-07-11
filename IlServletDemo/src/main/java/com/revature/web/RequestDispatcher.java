package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class RequestDispatcher
 */
/*
 * The Request Dispatcher is a design pattern that is used with servlets in many
 * frameworks. A Request Dispatcher is a servlet that dispatches requests to the 
 * appropriate classes in order for those requests to be processed. 
 * In other words, all requests will come through this servlet.
 * 
 * Our Request Dispatcher follows the Front Controller design pattern. A front controller is configured to intercept
 * all requests and dispatch them to some other resource.
 */
public class RequestDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * We'll be using Log4J2 in order to log throughout our application.
	 * Let's create a logger.
	 */
	
	private static final Logger LOGGY = LogManager.getLogger(RequestDispatcher.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOGGY.info("The request is in the Request Dispatcher. The Request URL is: " + request.getRequestURI());
		
		/*
		 * This method returns the HTTP VERB associated with the request.
		 */
		final String HTTPMETHOD = request.getMethod();
		
		if(HTTPMETHOD.equals("GET")) {
			/*
			 * Our Object Mapper (which comes from Jackson Core) is going to write a Java Object as JSON.
			 */
			response.getOutputStream().write(new ObjectMapper().writeValueAsBytes(RequestHelper.processGet(request, response)));
		}else {
			response.getOutputStream().write(new ObjectMapper().writeValueAsBytes(RequestHelper.processPost(request, response)));

		}
	}

}
