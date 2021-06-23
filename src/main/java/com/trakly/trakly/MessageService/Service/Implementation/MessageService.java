package com.trakly.trakly.MessageService.Service.Implementation;

import com.trakly.trakly.Models.Message;
import com.trakly.trakly.Models.Summary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface MessageService {
    Page<Message> getAllMessages(Pageable pageable);
    Message getMessageById(Long messageId);
    Message createMessage(Long senderId,Long receiverId, Message message);
    Message updateMessage(Long messageId, Message messageRequest);
    ResponseEntity<?> deleteMessage (Long messageId);
}
