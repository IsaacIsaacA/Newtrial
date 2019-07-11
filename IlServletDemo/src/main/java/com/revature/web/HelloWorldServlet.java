package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/*
	 *This is the doGet() method. It handles any GET requests which are intercepted by
	 *this servlet.
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPost(req, resp); //Notice that doGet calls doPost anyway...
	}
	
	/*
	 *This is the doPost method. It handles any POST requests which are intercepted by
	 *this servlet.
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
	}
}
