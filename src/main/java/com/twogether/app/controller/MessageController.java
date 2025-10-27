package com.twogether.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.twogether.app.model.Message;
import com.twogether.app.service.MessageService;

@RestController
@RequestMapping("/api/messages") 
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // GET /api/messages
    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    // GET /api/messages/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        Message message = messageService.getMessageById(id);
        if (message != null) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /api/messages
    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message savedMessage = messageService.saveMessage(message);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    // PUT /api/messages/{id} 
    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message message) {
        Message existing = messageService.getMessageById(id);
        if (existing != null) {
            existing.setMessage(message.getMessage());
            existing.setShippingDate(message.getShippingDate());
            Message updated = messageService.saveMessage(existing);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/messages/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        Message existing = messageService.getMessageById(id);
        if (existing != null) {
            messageService.deleteMessage(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}