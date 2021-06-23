package com.trakly.trakly.MessageService.Service;

import com.trakly.trakly.MessageService.Repository.MessageRepository;
import com.trakly.trakly.MessageService.Service.Implementation.MessageService;
import com.trakly.trakly.Models.Message;
import com.trakly.trakly.Models.Summary;
import com.trakly.trakly.WorkerService.Repository.WorkerRepository;
import com.trakly.trakly.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private WorkerRepository workerRepository;


    @Override
    public Page<Message> getAllMessages(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }

    @Override
    public Message getMessageById(Long messageId) {
        return messageRepository.findById(messageId)
                .orElseThrow(()->new ResourceNotFoundException("Message","Id",messageId));
    }

    @Override
    public Message createMessage(Long senderId,Long receiverId, Message message) {
        return workerRepository.findById(senderId).map(sender -> {
            message.setSender(sender);
            workerRepository.findById(receiverId).map(receiver -> {
                message.setReceiver(receiver);
                return messageRepository.save(message);
            }).orElseThrow(() -> new ResourceNotFoundException("Receiver","id", receiverId));
            return messageRepository.save(message);
        }).orElseThrow(() -> new ResourceNotFoundException("Sender", "Id", senderId));
    }

    @Override
    public Message updateMessage(Long messageId, Message messageRequest) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new ResourceNotFoundException("Message","Id",messageId));
        return messageRepository.save(
                message.setMessage(messageRequest.getMessage()).setReceiver(messageRequest.getReceiver()).setSender(messageRequest.getSender()).setSubject(messageRequest.getSubject()));
    }

    @Override
    public ResponseEntity<?> deleteMessage(Long messageId) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new ResourceNotFoundException("Message","Id",messageId));
        messageRepository.delete(message);
        return ResponseEntity.ok().build();
    }
}
