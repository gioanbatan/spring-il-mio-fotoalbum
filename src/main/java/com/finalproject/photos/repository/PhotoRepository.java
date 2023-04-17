package com.finalproject.photos.repository;

import com.finalproject.photos.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    public List<Photo> findByTitleContainingIgnoreCase(String title);
}
