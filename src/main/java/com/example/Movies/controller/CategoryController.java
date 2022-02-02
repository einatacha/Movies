package com.example.Movies.controller;
//
//
//import  java.net.URI;
//import java.util.List;
//
//import com.example.Movies.controller.dto.CategoryDto;
//import com.example.Movies.entities.Category;
//import com.example.Movies.service.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//
//
//import  io.swagger.annotations.Api;
//
//
//@Api
//@RestController
//@RequestMapping(value = "/movies")
//public class CategoryController {
//
//
//
//
//        @Autowired
//        private CategoryService categoryService;
//
//        @GetMapping(value = "/category")
//        public List<CategoryDto> list(){
//            List<Category> category = categoryService.findAll();
//            return CategoryDto.convert(category);
//        }
//
//        @GetMapping(value = "/category/{id}")
//        public List<CategoryDto> listCategory(@PathVariable(value="id") long id){
//
//            List<Category> category = categoryService.findById(id);
//            if(category != null) {
//
//                return CategoryDto.convertCategory(category);
//            }
//
//            List<Category> categories = categoryService.findAll();
//            return CategoryDto.convert(category);
//        }
//
//        @PostMapping(value = "/category/list")
//        public ResponseEntity<Category> Register(@RequestBody @Validated Category category UriComponentsBuilder uriBuilder) {
//            categoryService.save(category);
//
//            URI uri = uriBuilder.path("/movies/category/list/{id}").buildAndExpand(category.getId()).toUri();
//            return ResponseEntity.created(uri).body(category);
//        }
//
//
//    }
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.Movies.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Movies.service.CategoryService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping(value = "/movies")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @CrossOrigin
    @GetMapping(value = "/category")
    public List<Category> list() {
        return categoryService.findAll();
    }
    @CrossOrigin
    @GetMapping(value = "/category/{id}")
    public Optional<Category> listCategory(@PathVariable("id") Long id) {

       
            return categoryService.findById(id);
        }

   
    @CrossOrigin
    @PostMapping(value = "/category/register")
    public Category create(@RequestBody @Valid Category category) {
        return categoryService.save(category);
    }
    @CrossOrigin
    @PutMapping(value = "/category/update/{id}")
    public Category update(@PathVariable Long id, @RequestBody @Valid Category category) {
        return this.categoryService.update(category);
    }
    @CrossOrigin
    @DeleteMapping(value = "/category/delete/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
    @CrossOrigin
    @PutMapping(value = "/category/active/{id}")
    public Category active(@PathVariable Long id, @RequestBody @Valid Category categories) {
        categories.setActive(false);
        return this.categoryService.update(categories);


    }
}
