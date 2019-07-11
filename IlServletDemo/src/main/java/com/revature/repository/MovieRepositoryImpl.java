package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Movie;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class MovieRepositoryImpl implements MovieRepository{

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "SELECT * FROM servlets.movie";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			while(set.next()) {
				movies.add(new Movie(
						set.getInt(1),
						set.getString(2),
						set.getInt(3),
						set.getString(4),
						set.getInt(5)));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		return movies;
	}

	@Override
	public void insertMovie(Movie m) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "INSERT INTO servlets.movie VALUES(default, ?, ?, ?, ?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, m.getName());
			stmt.setInt(2, m.getRating());
			stmt.setString(3, m.getUrl());
			stmt.setInt(4, m.getGenreId());
			stmt.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
				
	}

}
