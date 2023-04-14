package com.finalproject.photos.service;

import com.finalproject.photos.exception.PhotoNotFoundException;
import com.finalproject.photos.model.Photo;
import com.finalproject.photos.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    public List<Photo> getAllPhotos() {
        return photoRepository.findAll(Sort.by("id"));
    }

    public Photo getPhotoById(Integer id) {
        Optional<Photo> result = photoRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new PhotoNotFoundException("Image not found.");
        }
    }
}
