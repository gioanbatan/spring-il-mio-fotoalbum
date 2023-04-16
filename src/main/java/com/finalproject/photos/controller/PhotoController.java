package com.finalproject.photos.controller;

import com.finalproject.photos.exception.PhotoNotFoundException;
import com.finalproject.photos.model.AlertMessage;
import com.finalproject.photos.model.Photo;
import com.finalproject.photos.repository.PhotoRepository;
import com.finalproject.photos.service.CategoryService;
import com.finalproject.photos.service.PhotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/photos")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private CategoryService categoryService;

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
        model.addAttribute("categoriesIndex", categoryService.getAllCategories());
        return ("/photos/show");
    }

    @GetMapping("/create")
    public String create(Model model) {
        Photo newPhoto = new Photo();
        model.addAttribute("photo", newPhoto);
        model.addAttribute("categoriesIndex", categoryService.getAllCategories());
        return ("/photos/create");
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("photo") Photo formPhoto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoriesIndex", categoryService.getAllCategories());
            return "/photos/create";
        }
        photoService.createPhoto(formPhoto);
        return "redirect:/photos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) throws PhotoNotFoundException {
        try {
            model.addAttribute("photo", photoService.getPhotoById(id));
            model.addAttribute("categoriesIndex", categoryService.getAllCategories());
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

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            Optional<Photo> result = photoRepository.findById(id);
            Boolean success = photoService.deletePhotoById(id);
            if (success) {
                redirectAttributes.addFlashAttribute("message", new AlertMessage(AlertMessage.AlertMessagesType.SUCCESS, "Photo " + result.get().getTitle() + " deleted successfully."));
                return "redirect:/photos";
            } else {
                redirectAttributes.addFlashAttribute("message",
                        new AlertMessage(AlertMessage.AlertMessagesType.ERROR, "ERROR - Can't delete " + result.get().getTitle() + "."));
            }
        } catch (PhotoNotFoundException e) {
            redirectAttributes.addFlashAttribute("message",
                    new AlertMessage(AlertMessage.AlertMessagesType.ERROR, "ERROR - Photo don't found."));
        }
        return "redirect:/photos";
    }
}