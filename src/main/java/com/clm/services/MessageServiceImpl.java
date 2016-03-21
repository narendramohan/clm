package com.clm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clm.dao.MessageDao;
import com.clm.entities.Message;
import com.clm.repositories.MessageRepository;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private MessageDao messageDao;
	@Override
	public List<Message> findAll() {
		messageRepository.findAll();
		return messageRepository.findAll();
	}
	
	public void createMessage(List<Message> ms){
		messageRepository.save(ms);
		messageRepository.flush();
	}
	public void deleteMessages(){
		messageDao.deleteAll();
	}
	public void saveAllMessage(List<Message> ms){
		messageDao.saveAllMessage(ms);
		
	}
	
}
