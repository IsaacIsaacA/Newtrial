package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// a cookie is a key value pair that you use to track session, the cookie is stored on the client side, a cookie is sent back to the clent in the serponse and storesd ion the client sideCookie is a chocolate chip new cook
/**
 * Servlet implementation class cookies
 */
public class cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//we can create using the constructor, it takes a key value pairAfter we created our cookies we add then to the response, they will b e sent to the client side once we add the
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie ch =new Cookie("cooke1", "fakjegfakrh"); 
		Cookie macadamianuut=new Cookie("cooke1", "devfhaghsfgkafhgake"); 
		ch.setHttpOnly(true);
		//If weant to to protect our cookies from XSS, cross side scriting we need to send http only
		response.addCookie(ch);
		
		response.addCookie(macadamianuut);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
