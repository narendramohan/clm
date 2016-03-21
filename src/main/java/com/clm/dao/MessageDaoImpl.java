package com.clm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clm.entities.Message;

@Service("messageDao")
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
	public void saveAllMessage(List<Message> ms){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		
		for(Message m:ms){
			try{
			s.saveOrUpdate(m);
			} catch (Exception e){
				
			}
		}
		s.getTransaction().commit();
	}

	@Override
	public void deleteAll() {
		try{
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		
		Query q1 = s.createQuery("DELETE FROM Message");
		q1.executeUpdate();
		s.getTransaction().commit();
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
