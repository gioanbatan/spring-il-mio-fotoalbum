package com.finalproject.photos.controller;

import com.finalproject.photos.exception.PhotoNotFoundException;
import com.finalproject.photos.model.Photo;
import com.finalproject.photos.repository.PhotoRepository;
import com.finalproject.photos.service.PhotoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/photos")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private PhotoRepository photoRepository;

    @GetMapping
    public String index(Model model) {
        List<Photo> photos;
        photos = photoService.getAllPhotos();

        model.addAttribute("photos", photos);
        return ("/photos/index");
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable Integer id) {
        Photo photo;
        photo = photoService.getPhotoById(id);

        model.addAttribute("photo", photo);
        return ("/photos/show");
    }

    @GetMapping("/create")
    public String create(Model model) {
        Photo newPhoto = new Photo();
        model.addAttribute("photo", newPhoto);
        return ("/photos/create");
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("photo") Photo formPhoto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/photos/create";
        }
        photoService.createPhoto(formPhoto);
        return "redirect:/photos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) throws PhotoNotFoundException {
        try {
            model.addAttribute("photo", photoService.getPhotoById(id));
            return "/photos/edit";
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo with id " + id + " not found.");
        }
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute Photo formPhoto, BindingResult bindingResult, Model model) throws PhotoNotFoundException {
        if (bindingResult.hasErrors()) {
            return "/photos/edit";
        }
        try {
            Photo updatedPhoto = photoService.updatePhoto(formPhoto, id);
            photoRepository.save(formPhoto);
            return "redirect:/photos/" + Integer.toString(updatedPhoto.getId());
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo with id " + id + " not found.");
        }
    }
}
