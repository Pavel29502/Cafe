package cafe.controller;

import cafe.bean.Category;
import cafe.repository.MenuRepository;
import cafe.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;
    private final MenuRepository menuRepository;

    public CategoryController(CategoryService categoryService,
                              MenuRepository menuRepository) {
        this.categoryService = categoryService;
        this.menuRepository = menuRepository;
    }
    @GetMapping("/categories")
    public String findAll(Model model) {
        List<Category> findCategory = categoryService.findAll();
        model.addAttribute("categories", findCategory);
        return "category/category-list";
    }
        @GetMapping("/category-create")
        public String createCategoryForm(Category category) {
            return "category/category-create";
        }
        @PostMapping("/category-create")
        public String createCategory(Category category) {
            categoryService.saveCategory(category);
            return "redirect:/categories";
        }
        @GetMapping("/category-delete/{id}")
        public String deleteCategory(@PathVariable("id") Long id) {
            categoryService.deleteById(id);
            return "redirect:/categories";
        }
        @GetMapping("/category-update/{id}")
        public String updateCategoryForm(@PathVariable("id") Long id, Model model) {
            Category category = categoryService.findById(id);
            model.addAttribute("category", category);
            return "category/category-update";
        }
        @PostMapping("/category-update")
        public String updateCategory(Category category){
            categoryService.saveCategory(category);
            return "redirect:/categories";
        }

//        @GetMapping("/categoryId/{id}")
//        public List<Category> getCategoryById(@PathVariable("id") Long id) {
//        Category category = categoryService.getById(id);
//        .addAttribute("category", category);
//        return "categories";
//        }

}


