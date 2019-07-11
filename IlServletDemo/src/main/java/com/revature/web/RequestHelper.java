package com.revature.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Movie;
import com.revature.model.User;
import com.revature.service.MovieServiceImpl;
import com.revature.service.UserServiceImpl;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

/*
 * Our Request is a class that returns objects to our Request Dispatcher Servlet.
 */
@WebServlet("/upload")
@MultipartConfig
public class RequestHelper {

	public static final Logger LOGGY = LogManager.getLogger(RequestHelper.class);

	public static Object processGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		final String URI = req.getRequestURI().replace("/ServletDemo/getflixapi", "");

		switch (URI) {

		case "/movie/all":
			return new MovieServiceImpl().getAllMovies();

		default:
			return "RESOURCE NOT FOUND";
		}
	}

	@SuppressWarnings("finally")
	public static Object processPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String SessionUser = null;
		String SessionPassword = null;
		final String URI = req.getRequestURI().replace("/ServletDemo/getflixapi", "");

		switch (URI) {

		case "/login":
			if (true) {

				int k = 0;
				User u = null;
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet set = null;
				final String SQL = "SELECT * FROM users WHERE username = ?";
				String username = req.getParameter("username");
				Cookie cookie = new Cookie("theuser", username);
				System.out.println("username is" + username);
				try {
					conn = ConnectionFactory.getConnection();
					stmt = conn.prepareStatement(SQL);
					stmt.setString(1, username);
					set = stmt.executeQuery();
					System.out.println("k");

					while (set.next()) {
						System.out.println("k==1");
						SessionUser = username;

						k++;
						// RequestDispatcher rd=request.getRequestDispatcher("./links.html");
						u = new User(set.getInt(1), set.getString(2), set.getString(3));

					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					System.out.println("finally block");
					ConnectionClosers.closeConnection(conn);
					ConnectionClosers.closeStatement(stmt);
					if (set != null) {
						ConnectionClosers.closeResultSet(set);
					}
					// javax.servlet.RequestDispatcher rd=req.getRequestDispatcher("./links.html");
					// rd.forward(req, resp);
					if (k > 0) {
						resp.sendRedirect("/ServletDemo/Pages/links.html");
						// resp.sendRedirect("./links.html");
						resp.addCookie(cookie);
						resp.setStatus(200);
						return "Login successful";
					} else {
						resp.sendRedirect("/ServletDemo/Pages/index.html");
						// resp.sendRedirect("./links.html");
						resp.addCookie(cookie);
						resp.setStatus(200);
						return "Login successful";
					}

				}

			} else {
				resp.sendError(403);
				return "Login was not successful";
			}
		case "/formcheckmanager":
			String usernameformanagerupdate = req.getParameter("name");
			System.out.println("You are in the managers update position" + usernameformanagerupdate);
			if (true) {

				User u = null;
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet set = null;
				final String SQL = "UPDATE forms SET Status = 1 WHERE username=?;";

				// System.out.println("username is" + username);
				try {
					conn = ConnectionFactory.getConnection();
					System.out.println(conn);
					stmt = conn.prepareStatement(SQL);
					stmt.setString(1, usernameformanagerupdate);
					System.out.println("I am bout to execute statemet");
					stmt.execute();
					System.out.println("k");

				} catch (SQLException e) {
					System.out.println("You have a syntax error");
					e.printStackTrace();
				} finally {
					System.out.println("finally block");
					ConnectionClosers.closeConnection(conn);
					// ConnectionClosers.closeStatement(stmt);
					// javax.servlet.RequestDispatcher rd=req.getRequestDispatcher("./links.html");
					// rd.forward(req, resp);
					resp.sendRedirect("/ServletDemo/Pages/links.html");
					// resp.sendRedirect("./links.html");
					resp.setStatus(200);
					return "Lkvya.GUfhE'waHI;ARusl";

				}

			} else {
				resp.sendError(403);
				return "Login was not successful";
			}

		case "/FormInput":
			System.out.println("Youare in the form input");
			String username = req.getParameter("username");
			//Cookie cookies[] = req.getCookies();
			if (true) {

				int k = 0;
				User u = null;
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet set = null;
				final String SQL = "SELECT * FROM users WHERE user_name = ?";
				username = req.getParameter("username");
				Cookie cookie = new Cookie("theuser", username);
				System.out.println("username is" + username);
				try {
					conn = ConnectionFactory.getConnection();
					stmt = conn.prepareStatement(SQL);
					stmt.setString(1, username);
					set = stmt.executeQuery();
					System.out.println("k");

					while (set.next()) {
						System.out.println("k==1");
						SessionUser = username;

						k++;
						// RequestDispatcher rd=request.getRequestDispatcher("./links.html");
						u = new User(set.getInt(1), set.getString(2), set.getString(3));

					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					System.out.println("finally block");
					ConnectionClosers.closeConnection(conn);
					ConnectionClosers.closeStatement(stmt);
					if (set != null) {
						ConnectionClosers.closeResultSet(set);
					}
					// javax.servlet.RequestDispatcher rd=req.getRequestDispatcher("./links.html");
					// rd.forward(req, resp);
					if (k == 0) {
						resp.sendRedirect("/ServletDemo/Pages/index.html");
						// resp.sendRedirect("./links.html");
						resp.addCookie(cookie);
						resp.setStatus(200);
						return "Login successful";
					} 

				}

			} 
			
			
			
			
			
			
			System.out.println("there isa a perswon who matc hes these characteristics");
			//System.out.println(cookies[0]);
			System.out.println(username);
			String password = req.getParameter("password");
			System.out.println(password);
			String date = req.getParameter("date");
			System.out.println(date);
			String time = req.getParameter("time");
			System.out.println(time);
			String location = req.getParameter("location");
			System.out.println(location);
			String description = req.getParameter("description");
			System.out.println(description);
			String cost = req.getParameter("Cost");
			System.out.println(cost);
			Part filePart = req.getPart("docpicker"); // Retrieves <input type="file" name="file">
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			InputStream fileContent = filePart.getInputStream();
			String status123 = "0";
			if (true) {

				User u = null;
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet set = null;
				final String SQL = "INSERT INTO forms " + "VALUES (?,?,?,?,?,?,?,?);";

				System.out.println("username is" + username);
				try {
					conn = ConnectionFactory.getConnection();
					System.out.println(conn);
					stmt = conn.prepareStatement(SQL);
					stmt.setString(1, username);
					stmt.setString(2, password);
					stmt.setString(3, date);
					stmt.setString(4, time);
					stmt.setString(5, location);
					stmt.setString(6, description);
					stmt.setString(7, cost);
					stmt.setString(8, status123);
					System.out.println("I am bout to execute statemet");
					LOGGY.info(username);
					LOGGY.info(cost);
					stmt.execute();
					System.out.println("k");

				} catch (SQLException e) {
					System.out.println("You have a syntax error");
					e.printStackTrace();
				} finally {
					System.out.println("finally block");
					ConnectionClosers.closeConnection(conn);
					ConnectionClosers.closeStatement(stmt);
					// javax.servlet.RequestDispatcher rd=req.getRequestDispatcher("./links.html");
					// rd.forward(req, resp);
					resp.sendRedirect("/ServletDemo/Pages/links.html");
					// resp.sendRedirect("./links.html");
					resp.setStatus(200);
					return "Lkvya.GUfhE'waHI;ARusl";

				}

			} else {
				resp.sendError(403);
				return "Login was not successful";
			}
		case "/Displayresults":
			if (true) {

				User u = null;
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet set = null;
				final String SQL = "SELECT * FROM forms";
				System.out.println(SQL);
				username = req.getParameter("username");
				String tableString = "<table>";
				System.out.println("username is" + username);
				try {
					conn = ConnectionFactory.getConnection();
					stmt = conn.prepareStatement(SQL);

					set = stmt.executeQuery();
					System.out.println("k");

					while (set.next()) {
						System.out.println("k==1");
						System.out.println(set.getString(1));
						tableString = tableString + "<tr>" + "<td>" + set.getString(1) + "</td>" + "<td>"
								+ set.getString("Status") + "</td>" + "</tr>";

					}
					tableString = tableString + "</table>";

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					System.out.println("finally block");
					ConnectionClosers.closeConnection(conn);
					// ConnectionClosers.closeStatement(stmt);
					ConnectionClosers.closeResultSet(set);
					// javax.servlet.RequestDispatcher rd=req.getRequestDispatcher("./links.html");
					// rd.forward(req, resp);

					return tableString;

				}

			} else {
				resp.sendError(403);
				return "Login was not successful";
			}
		case "/Displayresults2":
			if (true) {

				User u = null;
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet set = null;
				final String SQL = "SELECT * FROM forms WHERE Status=\'1\'";
				System.out.println(SQL);
				username = req.getParameter("username");
				String tableString = "<table>";
				System.out.println("username is" + username);
				try {
					conn = ConnectionFactory.getConnection();
					stmt = conn.prepareStatement(SQL);

					set = stmt.executeQuery();
					System.out.println("k");

					while (set.next()) {
						System.out.println("k==1");
						System.out.println(set.getString(1));
						tableString = tableString + "<tr>" + "<td>" + set.getString(1) + "</td>" + "<td>"
								+ set.getString("Status") + "</td>" + "</tr>";

					}
					tableString = tableString + "</table>";

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					System.out.println("finally block");
					ConnectionClosers.closeConnection(conn);
					// ConnectionClosers.closeStatement(stmt);
					ConnectionClosers.closeResultSet(set);
					// javax.servlet.RequestDispatcher rd=req.getRequestDispatcher("./links.html");
					// rd.forward(req, resp);

					return tableString;

				}

			} else {
				resp.sendError(403);
				return "Login was not successful";
			}

		case "/movie/create":
			System.out.println("You are in create");
			String body = req.getReader().lines().collect(Collectors.joining());
			// Movie received = new ObjectMapper().readValue(body, Movie.class);
			// LOGGY.info("The movie info is: "+ received);
			/*
			 * This code should be refactored/moved to the service layer.
			 */
			return new MovieServiceImpl().insertMovie(req, resp);

		default:
			// return "ENDPOINT NOT YET IMPLEMENTED";
//			javax.servlet.RequestDispatcher rd=req.getRequestDispatcher("links.html");
//			rd.forward(req, resp);
			// resp.sendRedirect("Servletdemo/links.html");
			// resp.sendRedirect("/IlServletDemo/Pages/links.html");
			resp.sendRedirect("links.html");
			resp.setStatus(207);
			return "It comes here";
		}

	}
}
