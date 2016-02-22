package com.clm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clm.entities.User;
@Service("userDao")
public class UserDaoImpl implements UserDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User create(User user) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.saveOrUpdate(user);
		s.getTransaction().commit();
		return user;
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
