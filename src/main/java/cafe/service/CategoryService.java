package cafe.service;

import cafe.bean.Category;
import cafe.exception.BaseException;
import cafe.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new BaseException("NotFound category with id " + id));
    }
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new BaseException("NotFound category with id " + id));
    }
}






//    @GetMapping("/category-update/{id}")
//    public String updateCategoryForm(@PathVariable("id") Long id, Model model) {
//        Category category = categoryService.findById(id);
//        model.addAttribute("category", category);
//        return "category/category-update";
//    }
//
//    @GetMapping("/categoryId")
//    public List<Category> getCategoryById(@PathVariable("id") Long id, Model model) {
//        Category category = categoryService.findById(id);
//        model.addAttribute("category", category);
//        return "redirect:/categoryId";

