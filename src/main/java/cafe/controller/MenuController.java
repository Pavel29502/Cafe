package cafe.controller;
import cafe.bean.Menu;
import cafe.repository.MenuRepository;
import cafe.service.CategoryService;
import cafe.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MenuController {

    private final MenuService menuService;
    private final CategoryService categoryService;
    private final MenuRepository menuRepository;
//    private final PreorderInfoRepository preorderInfoRepository;

    public MenuController(MenuService menuService, CategoryService categoryService,
                          MenuRepository menuRepository) {
        this.menuService = menuService;
        this.categoryService = categoryService;
//        this.preorderInfoRepository = preorderInfoRepository;
        this.menuRepository = menuRepository;
    }

    @GetMapping("/menu/{id}")
    public String findAll(Model model,
                          @PathVariable("id") long orderId) {
        List<Menu> findProduct = menuService.findAll();
        model.addAttribute("menu", findProduct);
        model.addAttribute("orderId", orderId);
        return "menu/menu-list";
    }

    @GetMapping("/menu-create")
    public String createMenuForm(Menu menu) {
        return "menu/menu-create";
    }

    @PostMapping("/menu-create")
    public String createMenu(Menu menu) {
        menuService.saveMenu(menu);
        return "redirect:/menu/0";

    }

//    @GetMapping("/menu/menu-update/{id}")
    @GetMapping("/menu-update/{id}")
    public String updateMenuForm(@PathVariable("id") Long id, Model model) {
//        Menu menu = menuService.getMenuById(id);
        Menu menu = menuRepository.findById(id).get();
        System.out.println("GET MENU="+menu);
        model.addAttribute("menu", menu);
        return "menu/menu-update";
    }
//    @PostMapping("/menu-update")
//    public String updateCategory(Menu menu){
//        menuService.saveMenu(menu);
//        return "redirect:/menu/0";
//    }

    @PostMapping("/menu-update/{id}")
    public String updateCategory(@PathVariable("id") Long id, @ModelAttribute("menu") Menu menu){
        menu.setId(id);
        menuRepository.save(menu);
        //menuService.saveMenu(menu);
        return "redirect:/menu-list";
    }

    @GetMapping("/menu-delete/{id}")
    public String deleteMenu(@PathVariable("id") Long id) {
        menuService.deleteById(id);
        return "redirect:/menu-list";
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




