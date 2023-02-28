package cafe.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
    @Entity
    @Table(name = "Preorder_info")
    public class PreorderInfo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;

        @OneToMany(fetch = FetchType.LAZY)
        @JoinColumn(name = "menu_id")
        private List<Menu> menuId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "preorder_id")
        private Preorder preorder;

        @Column(name = "review")
        private String review;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public List<Menu> getMenuId() {
            return menuId;
        }

        public void setMenuId(List<Menu> menuId) {
            this.menuId = menuId;
        }

        public Preorder getPreorder() {
            return preorder;
        }

        public void setPreorder(Preorder preorder) {
            this.preorder = preorder;
        }

        public String getReview() {
            return review;
        }

        public void setReview(String review) {
            this.review = review;
        }

        @Override
        public String toString() {
            return "PreorderInfo{" +
                    "id=" + id +
                    ", menuId=" + menuId +
                    ", preorder=" + preorder +
                    ", review='" + review + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PreorderInfo that = (PreorderInfo) o;
            return id == that.id && Objects.equals(menuId, that.menuId) && Objects.equals(preorder, that.preorder) && Objects.equals(review, that.review);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, menuId, preorder, review);
        }
    }
