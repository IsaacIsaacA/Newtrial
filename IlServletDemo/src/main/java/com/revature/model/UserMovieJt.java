package com.revature.model;

public class UserMovieJt {

	private int userId;
	private int movieId;
	
	public UserMovieJt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserMovieJt(int userId, int movieId) {
		super();
		this.userId = userId;
		this.movieId = movieId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + movieId;
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMovieJt other = (UserMovieJt) obj;
		if (movieId != other.movieId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserMovieJt [userId=" + userId + ", movieId=" + movieId + "]";
	}
}
