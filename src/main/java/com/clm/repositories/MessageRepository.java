package com.clm.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clm.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Serializable> {

}
