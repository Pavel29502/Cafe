package cafe.service;
import cafe.bean.Menu;
import cafe.exception.BaseException;
import cafe.repository.CategoryRepository;
import cafe.repository.MenuRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    public MenuService(MenuRepository menuRepository, CategoryService categoryService,
                       CategoryRepository categoryRepository) {
        this.menuRepository = menuRepository;
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }
    public List<Menu> findByTitle(String title) {
        return menuRepository.findByTitle(title);
    }


    public void saveMenu(Menu menu) {
        menuRepository.save(menu);
    }

//    public void saveMenu(Menu menu, Long id) {
//       Category category = categoryService.findById(id);
//        menu.setCategoryId(category);
//        menuRepository.save(menu);
//    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElseThrow(
                () ->  new BaseException("Not found menu with id " + id));
    }
//    public Menu saveMenu(Menu menu) {
//        Category category = new Category();
//        category.setCategory("pivas");
//        category.setId(1);
//        menu.setCategoryId(category);
//        return menuRepository.save(menu);

//      записываем через код.... ...

    public void deleteById(Long id) {
        menuRepository.deleteById(id);
    }

}
