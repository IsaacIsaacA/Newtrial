package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class trytoredirectplay
 */
public class trytoredirectplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trytoredirectplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//LOGGY.info("The request is in the Request Dispatcher. The Request URL is: " + request.getRequestURI());
		
		/*
		 * This method returns the HTTP VERB associated with the request.
		 */
		final String HTTPMETHOD = request.getMethod();
		
		if(HTTPMETHOD.equals("GET")) {
			System.out.println("I am in get");
			/*
			 * Our Object Mapper (which comes from Jackson Core) is going to write a Java Object as JSON.
			 */
			//response.getOutputStream().write(new ObjectMapper().writeValueAsBytes(requesth.processGet(request, response)));
		}else {
			System.out.println("I gott to a place");
			response.getOutputStream().write(new ObjectMapper().writeValueAsBytes(requesth.processPost(request, response)));

		}
	}

}
