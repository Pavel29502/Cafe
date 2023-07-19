package cafe.bean;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
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
//    @OneToOne(mappedBy = "preorder")
//    private Review preorderReview;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "preorder")
//    private List<PreorderInfo> preorderInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "preorder_time") // заменю тип немного позже
    private LocalDate preorderTime;
    @Column(name = "preorder_sum")
    private BigDecimal preorderSum;
    @Column(name = "preorder_type")
    @Enumerated(EnumType.STRING)
    private OrderType preorderType;
    @Column(name = "quantity")
    private long quantity;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Menu> menu;

    public OrderType getPreorderType() {
        return preorderType;
    }

    public void setPreorderType(OrderType preorderType) {
        this.preorderType = preorderType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public LocalDate getPreorderTime() {
        return preorderTime;
    }

    public void setPreorderTime(LocalDate preorderTime) {
        this.preorderTime = preorderTime;
    }

    public BigDecimal getPreorderSum() {
        return preorderSum;
    }

    public void setPreorderSum(BigDecimal preorderSum) {
        this.preorderSum = preorderSum;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Preorder{" +
                "id=" + id +
                ", userId=" + userId +
                ", preorderTime=" + preorderTime +
                ", quantity=" + quantity +
                ", menuId=" + menu +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preorder preorder = (Preorder) o;
        return id == preorder.id && quantity == preorder.quantity && Objects.equals(userId, preorder.userId) && Objects.equals(preorderTime, preorder.preorderTime) && Objects.equals(menu, preorder.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, preorderTime, quantity, menu);
    }
}
