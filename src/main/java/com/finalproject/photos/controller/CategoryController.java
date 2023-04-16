package com.finalproject.photos.controller;

import com.finalproject.photos.model.Category;
import com.finalproject.photos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String index(Model model) {
        List<Category> categories;
        categories = categoryService.getAllCategories();

        model.addAttribute("categoriesIndex", categories);
        return "/categories/index";
    }
}
