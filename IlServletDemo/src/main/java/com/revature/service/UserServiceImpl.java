package com.revature.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService {
	//private static final logger Loge

	@Override
	public boolean isValidUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		/*
		 * The getParameter() method gets parameters that have been submitted via a form
		 * by the NAME attribute. This example, for instance, is looking for submitted
		 * information that has the name "username".
		 */
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");

		/*
		 * This is a short circuit operator. It is considered efficient because it won't
		 * evaluate both sides of the operator if it doesn't have to.
		 */
		if (username != null && !username.equals("") && password != null && !password.equals("")) {
			UserRepository us = new UserRepositoryImpl();
			if (us.getUserByUsername(username) != null
					&& password.equals(us.getUserByUsername(username).getPassword())) {

				/*
				 * If the user is indeed authenticated, we can grant this user a session.
				 * There are several ways to manage sessions. We can:
				 * 
				 * 1)Use an HttpSession (a JSession/JSessionID)
				 * 2)Use a Cookie
				 * 3)Use a hidden input field on the client-side (BAD)
				 * 4)Append a session id to the end of the URL (MORE BADDER)
				 * 
				 * NOTE: If you manage/store sessions on the server side, your API is not
				 * 100% RESTful.
				 */
				
				/*
				 * We're creating a new JSession here. If we pass in no arguments, we
				 * create a new session. If we pass in a boolean value of false, we will
				 * not create a new session and instead get pre-existing session info
				 * back. If no such session exists in that case, this getSession() method
				 * returns null.
				 */
				HttpSession s = req.getSession();
				
				/*
				 * We can use sessions to set attributes to personalize user experience, to
				 * authenticate users, etc. This method, for instance, sets a session
				 * attribute that can be accessed by retrieving session information.
				 */
				
				s.setAttribute("user's name", username);
				
				/*
				 * Let's now redirect our client to a home page of some sort after successful
				 * login. We have several options for forwarding our client's request:
				 * 
				 * 1) We can use forward()
				 * 2) We can use sendRedirect()
				 * 
				 * The forward() method simply forwards the current request to a new resource. As
				 * a result, it's faster than sendRedirect(). It does not, however, reveal the
				 * name the of the resource to which the request is redirected, nor can it be
				 * used to direct a user to a domain located on a different server.
				 * 
				 * The sendRedirect method sends a response back the client side and proceeds to
				 * send another request, which means TWO requests are ultimately sent. As a 
				 * result, it's slower. It can, however, be used to direct a user to a domain
				 * which is located on a different server.
				 */
				
				RequestDispatcher dispatchy = req.getRequestDispatcher("/Pages/now-playing.html");
				dispatchy.forward(req, resp);
				return true;
			}
		}

		return false;
	}

}
