package com.clm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clm.entities.Message;

@Service("userDao")
public class MessageDaoImpl implements MessageDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<Message> findAll() {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		return null;
	}

	@Override
	public void create(Message message) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.saveOrUpdate(message);
		s.getTransaction().commit();
	}

	@Override
	public Message findUserByTopic(String topic) {
		
		return null;
	}

}
