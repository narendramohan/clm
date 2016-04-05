package com.clm.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.id.UUIDGenerator;

@Entity
@Table(name = "message")
public class Message implements Serializable
{
	public Message() {
	}
	public Message(String id, String topic, String message) {
		super();
		this.id = id;
		this.topic = topic;
		this.message = message;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name = "id")
	private String id;
	@Column(name = "topic")
	public String topic;
	@Column(name = "message")
	public String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
