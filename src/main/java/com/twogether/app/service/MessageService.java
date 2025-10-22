package com.twogether.app.service;

import java.util.List;

import com.twogether.app.model.Message;


public interface MessageService {
	List<Message> getAllMessages();
    Message getMessageById(Long id);
    Message saveMessage(Message message);
    void deleteMessage(Long id);
}
