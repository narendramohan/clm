/**
 * 
 */
package com.clm.dao;

import java.util.List;

import com.clm.entities.User;

/**
 * @author Narendra
 *
 */
public interface UserDao {

	public List<User> findAll();
	
	public User create(User user);
	
	public User findUserById(int id);

	public User login(String email, String password);
	
}
