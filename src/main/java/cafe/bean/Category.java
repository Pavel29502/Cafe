package cafe.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
    @Entity
    @Table(name = "Category")
    public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryId")
        private List<Menu> categoryMenu;
        @Column(name = "category")
        private String category;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public List<Menu> getCategoryMenu() {
            return categoryMenu;
        }

        public void setCategoryMenu(List<Menu> categoryMenu) {
            this.categoryMenu = categoryMenu;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", categoryMenu=" + categoryMenu +
                    ", category='" + category + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Category category1 = (Category) o;
            return id == category1.id && Objects.equals(categoryMenu, category1.categoryMenu) && Objects.equals(category, category1.category);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, categoryMenu, category);
        }
    }

