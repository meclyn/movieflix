package br.com.movieflix.controller;

import br.com.movieflix.controller.request.CategoryRequest;
import br.com.movieflix.controller.response.CategoryResponse;
import br.com.movieflix.entity.Category;
import br.com.movieflix.repository.CategoryRepository;
import br.com.movieflix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    // Listar todas as categorias
    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        return categoryService.findAll();
    }


    @PostMapping
    public CategoryResponse saveCategory(@RequestBody CategoryRequest request){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public CategoryResponse getByCategoryId(@PathVariable Long id){
        Optional<Category> optCategory = categoryService.findById(id);
        if(optCategory.isPresent()){
            return optCategory.get();
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
