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
        @ManyToOne(fetch = FetchType.LAZY)
        private PreorderInfo preorderInf;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "category_id")
        private Category categoryId;
        @Column(name = "title")
        private String title;
        @Column(name = "price")
        private long price;
        @Column(name = "points")
        private long points;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public PreorderInfo getPreorderInf() {
            return preorderInf;
        }

        public void setPreorderInf(PreorderInfo preorderInf) {
            this.preorderInf = preorderInf;
        }

        public Category getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Category categoryId) {
            this.categoryId = categoryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        public long getPoints() {
            return points;
        }

        public void setPoints(long points) {
            this.points = points;
        }

        @Override
        public String toString() {
            return "Menu{" +
                    "id=" + id +
                    ", preorderInf=" + preorderInf +
                    ", categoryId=" + categoryId +
                    ", title='" + title + '\'' +
                    ", price=" + price +
                    ", points=" + points +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Menu menu = (Menu) o;
            return id == menu.id && price == menu.price && points == menu.points && Objects.equals(preorderInf, menu.preorderInf) && Objects.equals(categoryId, menu.categoryId) && Objects.equals(title, menu.title);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, preorderInf, categoryId, title, price, points);
        }
    }

