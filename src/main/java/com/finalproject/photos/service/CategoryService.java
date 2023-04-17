package com.finalproject.photos.service;

import com.finalproject.photos.exception.CategoryNotFoundException;
import com.finalproject.photos.model.Category;
import com.finalproject.photos.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll(Sort.by("name"));
    }

    public Category getCategoryById(Integer id) throws RuntimeException {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public Category createCategory(Category formCategory) {
        Category categoryToCreate = new Category();

        categoryToCreate.setName(formCategory.getName());

        return categoryRepository.save(categoryToCreate);
    }

    public Category updateCategory(Category formCategory, Integer id) throws CategoryNotFoundException {
        try {
            Category categoryToUpdate = getCategoryById(id);
            categoryToUpdate.setName(formCategory.getName());
            return categoryRepository.save(categoryToUpdate);
        } catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found.");
        }
    }

}
