package cafe.controller;

import cafe.bean.Category;
import cafe.bean.Menu;
import cafe.service.CategoryService;
import cafe.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import static java.awt.SystemColor.menu;
@Controller
public class MenuController {

    private final MenuService menuService;
    private final CategoryService categoryService;
//    private final PreorderInfoRepository preorderInfoRepository;

    public MenuController(MenuService menuService, CategoryService categoryService) {
        this.menuService = menuService;
        this.categoryService = categoryService;
//        this.preorderInfoRepository = preorderInfoRepository;
    }

    @GetMapping("/menu")
    public String findAll(Model model) {
        List<Menu> findProduct = menuService.findAll();
        model.addAttribute("menu", findProduct);
//        model.addAttribute()
        return "menu/menu-list";
    }

    @GetMapping("/menu-create")
    public String createMenuForm(Menu menu) {
        return "menu/menu-create";
    }

    @PostMapping("/menu-create")
    public String createMenu(Menu menu) {
        menuService.saveMenu(menu);
        return "redirect:/menu";

    }
}




//    @PostMapping("/menu-create")
//    public String createMenu(Menu menu, Long id) {
//        menuService.saveMenu(menu, id);
//        return "redirect:/menu";
//    }

//    @PostMapping("/menu-create/{id}")
//    public String createMenu(Menu menu, Model model, @PathVariable Long id) {
//        menuService.saveMenu(menu, id);
//        List<Category> findCategory = categoryService.findAll();
//        model.addAttribute("categories", findCategory);
//        return "redirect:menu/menu-list";
//    }




//    @Controller
//    public class OrderController {
//
//        private final PreorderService preorderService;
//
//        public OrderController(PreorderService preorderService) {
//            this.preorderService = preorderService;
//        }
//
//        @GetMapping("/order/{id}")
//        public String getOrder(Model model,
//                               @PathVariable("id") Long menuId) {
//            PreorderInfo preorderInfo = preorderService.getOrder(menuId);
//            model.addAttribute("preorder", preorderInfo.getPreorder());
//            model.addAttribute("menu", preorderInfo.getMenuId().get(0));
//
//            return "order";




































//    @GetMapping("/new")
//    public String newProduct(Model model) {
//        model.addAttribute("newProductForm", new Product());
//        model.addAttribute("categories", categoryServiceImpl.findAll());
//        model.addAttribute("manufacturer", manufacturerServiceImpl.findAll());
//        model.addAttribute("supplier", supplierServiceImpl.findAll());
//
//        return "admin/product/newproduct";
//    }




