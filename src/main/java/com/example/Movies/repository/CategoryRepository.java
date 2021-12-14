package com.example.Movies.repository;
import com.example.Movies.entities.Category;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


        List<Category> findById(long categoryId);

}