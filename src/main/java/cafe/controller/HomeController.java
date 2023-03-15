package cafe.controller;

import cafe.bean.Category;
import cafe.bean.Menu;
import cafe.service.CategoryService;
import cafe.service.MenuService;
import cafe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final UserService userService;
    private final CategoryService categoryService;
    private final MenuService menuService;

    public HomeController(UserService userService, CategoryService categoryService,
                          MenuService menuService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.menuService = menuService;
    }

    @GetMapping("/admin")
    public String startPage(Model model) {
//        model.addAttribute("categories", categoryService.findAll());
//        model.addAttribute("menu", menuService.findAll());
//        model.addAttribute("users", userService.findAll());
        return "admin/admin-list";
    }

    @GetMapping("/category-list")
    public String findAll(Model model) {
        List<Category> findCategory = categoryService.findAll();
        model.addAttribute("categories", findCategory);
        return "category/category-list";
    }

    @GetMapping("/menu-list")
    public String findAllMenu(Model model) {
        List<Menu> findMenu = menuService.findAll();
        model.addAttribute("menu", findMenu);
        return "menu/menu-list";
    }

    @GetMapping("/user-list")
    public String findAllUsers(Model model) {
        List<Menu> findMenu = menuService.findAll();
        model.addAttribute("user", findMenu);
        return "user/user-list";
    }
    //Client
    @GetMapping("/client")
    public String startClient(Model model) {
        return "admin/client/client-list";
    }
}
