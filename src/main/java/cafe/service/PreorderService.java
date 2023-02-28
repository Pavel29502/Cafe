package cafe.service;

import cafe.bean.Menu;
import cafe.bean.Preorder;
import cafe.bean.PreorderInfo;
import cafe.bean.User;
import cafe.repository.PreorderInfoRepository;
import cafe.repository.PreorderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PreorderService {

private final PreorderRepository preorderRepository;
private final MenuService menuService;
private final UserService userService;
private final PreorderInfoRepository preorderInfoRepository;

public PreorderService(PreorderRepository preorderRepository, MenuService menuService, UserService userService, PreorderInfoRepository preorderInfoRepository) {
    this.preorderRepository = preorderRepository;
    this.menuService = menuService;
    this.userService = userService;
    this.preorderInfoRepository = preorderInfoRepository;
}

//    public List<Preorder> findByCategory(Long categoryId) {
//        return preorderRepository.findByCategory(categoryId);
//    }

    public PreorderInfo getOrder(Long id) {
    User user = userService.findById(1L);
    Preorder preorder = new Preorder();
    preorder.setUser(user);
    preorder.setPreorderTime(LocalDate.now());
    preorder.setPreorderType("CASH");
    preorderRepository.save(preorder);
    List<Menu> menuList = new ArrayList<>();
    Menu menu = menuService.getMenuById(id);
    preorder.setPreorderSum(menu.getPrice());
    menuList.add(menu);
    PreorderInfo preorderInfo = new PreorderInfo();
    preorderInfo.setMenuId(menuList);
    preorderInfo.setPreorder(preorder);
    preorderInfoRepository.save(preorderInfo);
    return preorderInfo;
    }
}
