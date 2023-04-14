package com.finalproject.photos.service;

import com.finalproject.photos.model.Photo;
import com.finalproject.photos.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    public List<Photo> getAllPhotos() {
        return photoRepository.findAll(Sort.by("id"));
    }
}
