package com._gether.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com._gether.app.model.Message;
import com._gether.app.repository.MessageRepository;
import com._gether.app.service.MessageService;


@Service
public class MessageServiceImpl implements MessageService{
	
	private final MessageRepository messageRepository;
	
	public MessageServiceImpl(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
    public List<Message> getAllMessages() {
        return (List<Message>) messageRepository.findAll();
    }

    @Override
    public Message getMessageById(Long id) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        return optionalMessage.orElse(null);
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

}
