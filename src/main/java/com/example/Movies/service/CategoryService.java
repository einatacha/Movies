package com.example.Movies.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Movies.entities.Category;

import com.example.Movies.repository.CategoryRepository;



@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category save(@Valid Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findById(long id) {
        return categoryRepository.findById(id);
    }

    public Category update(@Valid Category category) {
        return categoryRepository.saveAndFlush(category);
    }


    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

}


