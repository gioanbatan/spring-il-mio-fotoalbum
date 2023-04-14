package com.finalproject.photos.controller;

import com.finalproject.photos.model.Photo;
import com.finalproject.photos.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
