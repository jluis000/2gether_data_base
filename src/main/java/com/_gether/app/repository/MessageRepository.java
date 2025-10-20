package com._gether.app.repository;

import org.springframework.data.repository.CrudRepository;

import com._gether.app.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long>{

}
