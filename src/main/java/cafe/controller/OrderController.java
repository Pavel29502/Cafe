package cafe.controller;

import cafe.bean.PreorderInfo;
import cafe.service.PreorderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {

    private final PreorderService preorderService;

    public OrderController(PreorderService preorderService) {
        this.preorderService = preorderService;
    }

    @GetMapping("/order/{id}")
    public String getOrder(Model model,
                           @PathVariable("id") Long menuId) {
        PreorderInfo preorderInfo = preorderService.getOrder(menuId);
        model.addAttribute("preorder", preorderInfo.getPreorder());
        model.addAttribute("menu", preorderInfo.getMenuId().get(0));

        return "order";

    }
}
