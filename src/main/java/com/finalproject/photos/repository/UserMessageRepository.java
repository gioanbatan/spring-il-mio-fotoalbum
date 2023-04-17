package com.finalproject.photos.repository;

import com.finalproject.photos.model.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMessageRepository extends JpaRepository<UserMessage, Integer> {
}
