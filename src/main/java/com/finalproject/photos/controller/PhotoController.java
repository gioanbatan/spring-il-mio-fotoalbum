package com.finalproject.photos.controller;

import com.finalproject.photos.model.Photo;
import com.finalproject.photos.service.PhotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/photos")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

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
}
