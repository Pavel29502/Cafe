package cafe.controller;

import cafe.bean.Category;
import cafe.bean.User;
import cafe.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String findAll(Model model) {
        List<Category> findCategory = categoryService.findAll();
        model.addAttribute("categories", findCategory);
        return "Category/category-list";
    }

//    @GetMapping("/menu-create")
//    public String createUserForm(User user) {
//        return "menu-create";
//    }

}


