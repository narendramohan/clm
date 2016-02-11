/**
 * 
 */
package com.clm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clm.entities.User;
import com.clm.repositories.UserRepository;


/**
 * @author Narendra
 *
 */
@Service
@Transactional
public class UserService 
{
	//private UserDao userDao;
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	*/
	public List<User> findAll() {
		//return userDao.findAll();
		return userRepository.findAll();
	}

	public User create(User user) {
		//return userDao.create(user);
		return userRepository.save(user);
	}

	public User findUserById(int id) {
		//return userDao.findUserById(id);
		return userRepository.findOne(id);
	}

	public User login(String email, String password) {
		//return userDao.login(email,password);
		//return userRepository.login(email,password);
		return userRepository.findByEmailAndPassword(email,password);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(int id) {
		userRepository.delete(id);
	}

	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	public void saveUser(User user) {
		userRepository.save(user);
		
	}

	public boolean isUserSSOUnique(int id, String email) {
		User user = userRepository.findUserByEmail(email);
		return user!=null;
	}

	public void deleteUserBySSO(String email) {
		User user = userRepository.findUserByEmail(email);
		userRepository.delete(user.getId());
		
	}
	
	
}

