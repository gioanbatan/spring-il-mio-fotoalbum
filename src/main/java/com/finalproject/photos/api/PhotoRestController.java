package com.finalproject.photos.api;

import com.finalproject.photos.exception.PhotoNotFoundException;
import com.finalproject.photos.model.Photo;
import com.finalproject.photos.service.PhotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/photos")
public class PhotoRestController {

    @Autowired
    private PhotoService photoService;

    @GetMapping
    public List<Photo> list(@RequestParam(name = "q") Optional<String> search) {
        if (search.isPresent()) {
            return photoService.getFilteredPhotos(search.get());
        }
        return photoService.getAllPhotos();
    }

    @GetMapping("/{id}")
    public Photo getPhotoById(@PathVariable Integer id) throws PhotoNotFoundException, ResponseStatusException {
        try {
            return photoService.getPhotoById(id);
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
        }
    }

    @PostMapping
    public Photo create(@Valid @RequestBody Photo photo) {
        try {
            return photoService.createPhoto(photo);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Photo update(@PathVariable Integer id, @Valid @RequestBody Photo photo) throws PhotoNotFoundException, ResponseStatusException, Exception {
        try {
            return photoService.updatePhoto(photo, id);
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws PhotoNotFoundException, ResponseStatusException, Exception {
        try {
            photoService.deletePhotoById(id);
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
