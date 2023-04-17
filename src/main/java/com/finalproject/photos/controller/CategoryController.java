package com.finalproject.photos.controller;

import com.finalproject.photos.exception.PhotoNotFoundException;
import com.finalproject.photos.model.Category;
import com.finalproject.photos.model.Photo;
import com.finalproject.photos.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.sax.SAXResult;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String index(Model model, @RequestParam("id") Optional<Integer> id) {
        List<Category> categories;
        categories = categoryService.getAllCategories();
        model.addAttribute("categoriesIndex", categories);
        if (id.isPresent()) {
            model.addAttribute("categorySingle", categoryService.getCategoryById(id.get()));
        } else {
            model.addAttribute("categorySingle", new Category());
        }

        return "/categories/index";
    }

    @PostMapping
    public String update(@Valid @ModelAttribute(name = "categorySingle") Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Category> categories;
            categories = categoryService.getAllCategories();
            model.addAttribute("categoriesIndex", categories);
            return "/categories/index";
        }

        if (category.getId() != null) {
            categoryService.updateCategory(category, category.getId());
        } else {
            categoryService.createCategory(category);
        }

        return "redirect:/categories";
    }


}
