package cafe.controller;

import cafe.bean.Menu;
import cafe.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;

    }

    @GetMapping("/menu")
    public String findAll(Model model) {
        List<Menu> findProduct = menuService.findAll();
        model.addAttribute("menu", findProduct);
        return "menu-list";
    }

    @GetMapping("/menu-create")
    public String createMenuForm(Menu menu) {
        return "menu-create";
    }

    @PostMapping("/menu-create")
    public String createMenu(Menu menu) {
        menuService.saveMenu(menu);
        return "redirect:/menu";
    }




//    public String newMenu(Model model) {
//        model.addAttribute("createMenuForm", new Menu());
//        model.addAttribute()
//
//    }



//    @GetMapping("/new")
//    public String newProduct(Model model) {
//        model.addAttribute("newProductForm", new Product());
//        model.addAttribute("categories", categoryServiceImpl.findAll());
//        model.addAttribute("manufacturer", manufacturerServiceImpl.findAll());
//        model.addAttribute("supplier", supplierServiceImpl.findAll());
//
//        return "admin/product/newproduct";
//    }


}

