package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Services.Category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategorys() {
        return categoryService.getCategorys();
    }

    /*@GetMapping("/{id}")
    public Category getCategoryByID(@PathVariable Long id) throws MyEntityNotFoundException {
        return categoryService.getCategoryByID(id);
    }*/
    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryByID(@PathVariable Long id) {
        try {
            Category category = categoryService.getCategoryByID(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (MyEntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public Category createCategory(@RequestBody Category catalogue) {
        return categoryService.createCategory(catalogue);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("id")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category catalogue) throws MyEntityNotFoundException {
        return categoryService.updateCategory(id, catalogue);
    }
}
