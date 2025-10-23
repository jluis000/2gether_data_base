package com.twogether.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.twogether.app.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long>{

}