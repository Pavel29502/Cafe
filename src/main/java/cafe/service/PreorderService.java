package cafe.service;
import cafe.bean.Menu;
import cafe.bean.OrderType;
import cafe.bean.Preorder;
import cafe.bean.User;
import cafe.exception.BaseException;
import cafe.repository.PreorderRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PreorderService {
private final PreorderRepository preorderRepository;
private final MenuService menuService;
private final UserService userService;

public PreorderService(PreorderRepository preorderRepository, MenuService menuService, UserService userService) {
    this.preorderRepository = preorderRepository;
    this.menuService = menuService;
    this.userService = userService;
////    this.preorderInfoRepository = preorderInfoRepository;
}
    public Preorder saveOrder(Long orderId, Long menuId) {
        User user = userService.findById(1L);
        Menu menu = menuService.getMenuById(menuId);
        Optional<Preorder> order = preorderRepository.findById(orderId);
        if (order.isPresent()) {
            List<Menu> listMenu = order.get().getMenu();
            listMenu.add(menu);
            BigDecimal orderSum = getAllSum(listMenu);
            order.get().setPreorderSum(orderSum);
            order.get().setPreorderTime(LocalDate.now());
            order.get().setPreorderType(OrderType.CARD);
            preorderRepository.saveAndFlush(order.get());
            return order.get();
        } else {
            Preorder firstOrder = new Preorder();
            List<Menu> menuList = new ArrayList<>();
            menuList.add(menu);
            firstOrder.setPreorderType(OrderType.CARD);
            firstOrder.setMenu(menuList);
            firstOrder.setPreorderSum(menu.getPrice());
            firstOrder.setPreorderTime(LocalDate.now());
            firstOrder.setUserId(user);
            preorderRepository.saveAndFlush(firstOrder);
            return firstOrder;
        }
    }
    private BigDecimal getAllSum(List<Menu> menuList) {
        BigDecimal result = new BigDecimal(0);
        for (Menu sum: menuList) {
            result = result.add(sum.getPrice());
        }
        return result;
    }
    public Preorder deleteProductFromOrder(Long menuId, Long orderId) {
        Optional<Preorder> order = preorderRepository.findById(orderId);
        Menu menu = menuService.getMenuById(menuId);
        if(order.isPresent()) {
            List<Menu> menuList = order.get().getMenu();
            for(Menu product: menuList) {
                if (product.getId() == menuId) {
                    menuList.remove(product);
                    BigDecimal summ = order.get().getPreorderSum().subtract(product.getPrice());
                    order.get().setPreorderSum(summ);
                    break;
                }
            }
            order.get().setMenu(menuList);
            preorderRepository.saveAndFlush(order.get());
            return order.get();
        }
        return new Preorder();
    }

    public Preorder getOrderById(Long id) {
      return preorderRepository.findById(id).orElseThrow(
            () -> new BaseException("NotFound order wiht id " + id));
    }
}
