package com.finalproject.photos.service;

import com.finalproject.photos.exception.PhotoNotFoundException;
import com.finalproject.photos.model.Photo;
import com.finalproject.photos.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public List<Photo> getFilteredPhotos(String searchKey) {
        List<Photo> result = photoRepository.findByTitleContainingIgnoreCase(searchKey);
        if (result.size() > 0) {
            return result;
        } else {
            throw new PhotoNotFoundException("Images not found.");
        }
    }

    public Photo createPhoto(Photo formPhoto) {
        Photo photoToPersist = new Photo();

        photoToPersist.setId(photoToPersist.getId());
        photoToPersist.setTitle(formPhoto.getTitle());
        photoToPersist.setDescription(formPhoto.getDescription());
        photoToPersist.setUrl(formPhoto.getUrl());
        photoToPersist.setVisible(formPhoto.getVisible());
        photoToPersist.setCategories(formPhoto.getCategories());

        return photoRepository.save(photoToPersist);
    }

    public Photo updatePhoto(Photo formPhoto, Integer id) throws PhotoNotFoundException {
        try {
            Photo photoToUpdate = getPhotoById(id);

            photoToUpdate.setTitle(formPhoto.getTitle());
            photoToUpdate.setDescription(formPhoto.getDescription());
            photoToUpdate.setUrl(formPhoto.getUrl());
            photoToUpdate.setVisible(formPhoto.getVisible());

            return photoRepository.save(photoToUpdate);
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo with id " + id + " not found.");
        }
    }

    public Boolean deletePhotoById(Integer id) throws PhotoNotFoundException {
        try {
            photoRepository.deleteById(id);
            return true;
        } catch (PhotoNotFoundException e) {
            return false;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
