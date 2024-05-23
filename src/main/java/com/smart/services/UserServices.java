package com.smart.services;

import java.util.List;
import java.util.Optional;

import com.smart.entities.User;

public interface UserServices {

	User saveUser(User user);
	Optional<User> getUserById(String id);
	Optional<User> updateUser(User user);
	void deleteUser(String id);
	boolean isUserExist(String userId);
	boolean isUserExistByEmail(String email);
	List<User> getAllUsers();
	
	//add more methods here related user service[logic]
	
	
}
