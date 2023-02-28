package cafe.bean;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Preorder")
public class Preorder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @OneToOne(mappedBy = "preorder")
    private Review preorderReview;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "preorder")
    private List<PreorderInfo> preorderInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "preorder_time") // заменю тип немного позже
    private LocalDate preorderTime;
    @Column(name = "preorder_sum")
    private long preorderSum;
    @Column(name = "preorder_type")
    private String preorderType;

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

    public List<PreorderInfo> getPreorderInfo() {
        return preorderInfo;
    }

    public void setPreorderInfo(List<PreorderInfo> preorderInfo) {
        this.preorderInfo = preorderInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getPreorderTime() {
        return preorderTime;
    }

    public void setPreorderTime(LocalDate preorderTime) {
        this.preorderTime = preorderTime;
    }

    public long getPreorderSum() {
        return preorderSum;
    }

    public void setPreorderSum(long preorderSum) {
        this.preorderSum = preorderSum;
    }

    public String getPreorderType() {
        return preorderType;
    }

    public void setPreorderType(String preorderType) {
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
