package com.finalproject.photos.service;

import com.finalproject.photos.model.UserMessage;
import com.finalproject.photos.repository.UserMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMessageService {

    @Autowired
    private UserMessageRepository userMessageRepository;

    public UserMessage createUserMessage(UserMessage userMessage) {
        UserMessage messageToPersist = new UserMessage();

        messageToPersist.setId(userMessage.getId());
        messageToPersist.setEmail(userMessage.getEmail());
        messageToPersist.setContent(userMessage.getContent());

        return userMessageRepository.save(messageToPersist);
    }

}