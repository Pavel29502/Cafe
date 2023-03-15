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
//    @OneToOne(mappedBy = "preorder")
//    private Review preorderReview;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "preorder")
//    private List<PreorderInfo> preorderInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "preorder_time") // заменю тип немного позже
    private LocalDate preorderTime;
//    @Column(name = "preorder_sum")
//    private long preorderSum;
//    @Column(name = "preorder_type")
//    private String preorderType;
    @Column(name = "quantity")
    private long quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menuId;

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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "Preorder{" +
                "id=" + id +
                ", userId=" + userId +
                ", preorderTime=" + preorderTime +
                ", quantity=" + quantity +
                ", menuId=" + menuId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preorder preorder = (Preorder) o;
        return id == preorder.id && quantity == preorder.quantity && Objects.equals(userId, preorder.userId) && Objects.equals(preorderTime, preorder.preorderTime) && Objects.equals(menuId, preorder.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, preorderTime, quantity, menuId);
    }
}
