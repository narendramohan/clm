package com.clm.services;

import java.util.List;

import com.clm.entities.Message;

public interface MessageService {
	List<Message> findAll();
	public void createMessage(List<Message> ms);
	public void deleteMessages();
	public void saveAllMessage(List<Message> ms);
}
