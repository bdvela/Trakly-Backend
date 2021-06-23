package com.trakly.trakly.MessageService.Controller;

import com.trakly.trakly.AreaService.Resource.AreaResource;
import com.trakly.trakly.MessageService.Resource.MessageResource;
import com.trakly.trakly.MessageService.Resource.SaveMessageResource;
import com.trakly.trakly.MessageService.Service.Implementation.MessageService;
import com.trakly.trakly.Models.Message;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Post Message", description="Create Message", tags={"messages"})
    @PostMapping("/worker/{senderId}/worker/{receiverId}")
    public MessageResource createMessage(@PathVariable Long senderId,@PathVariable Long receiverId, @Valid @RequestBody SaveMessageResource resource) {
        Message message = convertToEntity(resource);
        return convertToResource(messageService.createMessage(senderId,receiverId,message));
    }

    @Operation(summary = "Get Message", description = "Get All Messages", tags = {"messages"})
    @GetMapping("/message")
    public Page<MessageResource> getAllMessages(Pageable pageable){
        Page<Message> messagePage = messageService.getAllMessages(pageable);
        List<MessageResource> resources = messagePage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary = "Delete Message", description = "Delete Message", tags = {"messages"})
    @DeleteMapping("/message/{messageId}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long messageId){
        return messageService.deleteMessage(messageId);
    }

    @Operation(summary = "Get Message by Id", description = "Get Message by Id", tags = {"messages"})
    @GetMapping("/message/{messageId}")
    public MessageResource getMessageResource(@PathVariable Long messageId){
        return convertToResource(messageService.getMessageById(messageId));
    }

    private Message convertToEntity(SaveMessageResource resource) {
        return mapper.map(resource, Message.class);
    }
    private MessageResource convertToResource(Message entity)
    {
        return mapper.map(entity, MessageResource.class);
    }
}
