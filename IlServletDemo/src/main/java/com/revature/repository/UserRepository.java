package com.revature.repository;

import com.revature.model.User;

public interface UserRepository {

	User getUserByUsername(String username);
	
}
