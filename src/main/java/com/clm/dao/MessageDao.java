package com.clm.dao;

import java.util.List;

import com.clm.entities.Message;



public interface MessageDao {
	public List<Message> findAll();
	
	public void create(Message message);
	
	public Message findUserByTopic(String topic);
	public void saveAllMessage(List<Message> ms);

	public void deleteAll();
}
