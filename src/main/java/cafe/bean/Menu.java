package cafe.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

    @Entity
    @Table(name = "Menu")
    public class Menu {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;
//        @ManyToOne(fetch = FetchType.LAZY)
//        private PreorderInfo preorderInf;
        //new
//        @ManyToOne(fetch = FetchType.EAGER)
//        @JoinColumn(name = "category_id")
//      private Category category = new Category();
//        private Category categoryId;
        @Column(name = "title")
        private String title;
        @Column(name = "description_product")
        private String description;
        @Column(name = "price")
        private long price;
//        @Column(name = "points")
//        private long points;


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Menu{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", price=" + price +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Menu menu = (Menu) o;
            return id == menu.id && price == menu.price && Objects.equals(title, menu.title) && Objects.equals(description, menu.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, title, description, price);
        }
    }

