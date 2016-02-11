package com.clm.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clm.entities.Topic;

public interface TopicRepository extends JpaRepository<Topic, Serializable>{
	Topic findTopicByName(String name);
}
