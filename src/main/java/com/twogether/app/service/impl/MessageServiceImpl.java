package com.twogether.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.twogether.app.model.Message;
import com.twogether.app.repository.MessageRepository;
import com.twogether.app.service.MessageService;


@Service
public class MessageServiceImpl implements MessageService {
	private final MessageRepository messageRepository;
	
	
	public MessageServiceImpl(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public List<Message> getAllMessages() {
	    // Devuelve todos los mensajes de la base de datos
	    return (List<Message>) messageRepository.findAll();
	}

	@Override
	public Message getMessageById(Long id) {
	    // Busca un mensaje por ID, devuelve null si no lo encuentra
	    return messageRepository.findById(id).orElse(null);
	}

	@Override
	public Message saveMessage(Message message) {
	    // Guarda un nuevo mensaje o actualiza uno existente
	    return messageRepository.save(message);
	}

	@Override
	public void deleteMessage(Long id) {
	    // Elimina un mensaje por ID
		messageRepository.deleteById(id);
	}

   
}