package cafe.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

    @Entity
    @Table(name = "Review")
    public class Review {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        private User userReview;
//        @OneToOne(fetch = FetchType.LAZY)
//        @JoinColumn(name = "preorder_id")
//        private Preorder preorder;
//        @OneToMany(fetch = FetchType.LAZY)
//        private List<Preorder> preorderIdd;
        @Column(name = "review")
        private String review;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public User getUserReview() {
            return userReview;
        }

        public void setUserReview(User userReview) {
            this.userReview = userReview;
        }

        public String getReview() {
            return review;
        }

        public void setReview(String review) {
            this.review = review;
        }

        @Override
        public String toString() {
            return "Review{" +
                    "id=" + id +
                    ", userReview=" + userReview +
                    ", review='" + review + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Review review1 = (Review) o;
            return id == review1.id && Objects.equals(userReview, review1.userReview) && Objects.equals(review, review1.review);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, userReview, review);
        }
    }



