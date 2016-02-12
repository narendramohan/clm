package com.clm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clm.entities.Topic;
import com.clm.repositories.TopicRepository;
@Service
@Transactional
public class TopicServiceImpl implements TopicService {
	@Autowired
	private TopicRepository topicRepository;
	@Override
	public List<Topic> findAll() {
		
		return topicRepository.findAll();
	}

}
