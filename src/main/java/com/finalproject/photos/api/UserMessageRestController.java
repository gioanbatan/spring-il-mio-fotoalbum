package com.finalproject.photos.api;

import com.finalproject.photos.model.UserMessage;
import com.finalproject.photos.service.UserMessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/messages")
public class UserMessageRestController {
    @Autowired
    private UserMessageService userMessageService;

    @PostMapping
    public UserMessage create(@Valid @RequestBody UserMessage userMessage) {
        try {
            return userMessageService.createUserMessage(userMessage);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
