package com.revature.web;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Responseyype
 */
public class Responseyype extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Responseyype() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//so far we have been working with sending json back to the client sidem but we vcan also send other things back to the client side, egwe can set our content type to be text/html, text/plainetc
	//inorder to send data back to the client, we can use a print writer
	//preint write isnt specific to servlets , though we can get a printwriter with the getwriter
	PrintWriter out=response.getWriter();
	//we can specify what we want to send back to the content type using the set content type method.It takes content type as a string argument
	
	//response.setContentType("application/json");
	
	response.setContentType("text/html");
	Date dat=new Date();
	String dat2=dat.toString();
	//out.write("<h1>I have a life problem</h1>");
	//out.write("<p>"+dat2+"</p>");
	out.write("<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta charset=\"ISO-8859-1\">\r\n" + 
			"<title>Insert title here</title>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"<A HREF=\"./index.html\">index</A>\r\n" + 
			"<A HREF=\"index2forProjectLogin.html\">indexforsecondpage</A>\r\n" + "<p>"+dat2+"</p>"+
			"</body>\r\n" + 
			"</html>");
	}

	private void outwrite(String string) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("you are in the right place");
		System.out.println("getting closer");
		response.getOutputStream().write(new ObjectMapper().writeValueAsBytes(Requesthelp2.processPost(request, response)));
		//doGet(request, response);
	}

}
