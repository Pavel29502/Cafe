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

//        @OneToMany(fetch = FetchType.LAZY)
////        @JoinColumn(name = "menu_id")
////        private List<Menu> menuId;
//
////        @ManyToOne(fetch = FetchType.LAZY)
////        @JoinColumn(name = "preorder_id")
////        private Preorder preorder;

        @Column(name = "review")
        private String review;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
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
                    ", review='" + review + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PreorderInfo that = (PreorderInfo) o;
            return id == that.id && Objects.equals(review, that.review);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, review);
        }
    }
