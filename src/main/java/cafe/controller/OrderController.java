package cafe.controller;


import cafe.bean.Preorder;
import cafe.service.PreorderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    private final PreorderService preorderService;

    public OrderController(PreorderService preorderService) {
        this.preorderService = preorderService;
    }
    @GetMapping("/menu/order/{id}/{orderId}")
    public String getOrder(Model model,
                           @PathVariable("id") Long menuId,
                           @PathVariable("orderId") Long orderId) {
        Preorder preorder = preorderService.saveOrder(orderId, menuId);
        model.addAttribute("preorder", preorder);
        model.addAttribute("menu", preorder.getMenu());
        return "preorder/order";
    }
    @GetMapping("menu/{id}/order-delete/{orderId}")
    public String deleteProductFromOrder(Model model,
                           @PathVariable("id") Long menuId,
                           @PathVariable("orderId") Long orderId) {
        Preorder preorder = preorderService.deleteProductFromOrder(menuId, orderId);
        model.addAttribute("preorder", preorder);
        model.addAttribute("menu", preorder.getMenu());
        return "redirect:/order/" + orderId;
    }
    @GetMapping("order/{orderId}")
    public String showAllOrder(Model model, @PathVariable("orderId") Long orderId) {
      Preorder preorder = preorderService.getOrderById(orderId);
      model.addAttribute("preorder", preorder);
      model.addAttribute("menu", preorder.getMenu());
      return "preorder/order";
    }

}
