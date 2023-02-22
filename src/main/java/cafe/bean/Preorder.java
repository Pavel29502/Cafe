package cafe.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Preorder")
public class Preorder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @OneToOne(mappedBy = "preorderId")
    private Review preorderReview;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "preorderId")
    private List<PreorderInfo> preorderInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "preorder_time") // заменю тип немного позже
    private long preorderTime;
    @Column(name = "preorder_sum")
    private long preorderSum;
    @Column(name = "preorder_type")
    private long preorderType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Review getPreorderReview() {
        return preorderReview;
    }

    public void setPreorderReview(Review preorderReview) {
        this.preorderReview = preorderReview;
    }

    public List<PreorderInfo> getPreorderInfoo() {
        return preorderInfo;
    }

    public void setPreorderInfoo(List<PreorderInfo> preorderInfoo) {
        this.preorderInfo = preorderInfoo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getPreorderTime() {
        return preorderTime;
    }

    public void setPreorderTime(long preorderTime) {
        this.preorderTime = preorderTime;
    }

    public long getPreorderSum() {
        return preorderSum;
    }

    public void setPreorderSum(long prorderSum) {
        this.preorderSum = prorderSum;
    }

    public long getPreorderType() {
        return preorderType;
    }

    public void setPreorderType(long preorderType) {
        this.preorderType = preorderType;
    }

    @Override
    public String toString() {
        return "Preorder{" +
                "id=" + id +
                ", preorderReview=" + preorderReview +
                ", preorderInfo=" + preorderInfo +
                ", user=" + user +
                ", preorderTime=" + preorderTime +
                ", preorderSum=" + preorderSum +
                ", preorderType=" + preorderType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preorder preorder = (Preorder) o;
        return id == preorder.id && preorderTime == preorder.preorderTime && preorderSum == preorder.preorderSum && preorderType == preorder.preorderType && Objects.equals(preorderReview, preorder.preorderReview) && Objects.equals(preorderInfo, preorder.preorderInfo) && Objects.equals(user, preorder.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, preorderReview, preorderInfo, user, preorderTime, preorderSum, preorderType);
    }
}
