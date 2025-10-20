package com._gether.app.service;

import com._gether.app.model.Message;
import java.util.List;

public interface MessageService {
	List<Message> getAllMessages();
    Message getMessageById(Long id);
    Message saveMessage(Message message);
    void deleteMessage(Long id);
}
