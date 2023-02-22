package cafe.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Preorder> preorder;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userReview")
    private List<Review> newReview;
    @Column(name = "user_name")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "pass")
    private String pass;
    @Column(name = "email")
    private String email;
    @Column(name = "user_role")
    private String role;
    @Column(name = "points")
    private long points;
    @Column(name = "ban")
    private boolean ban;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Preorder> getPreorder() {
        return preorder;
    }

    public void setPreorder(List<Preorder> preorder) {
        this.preorder = preorder;
    }

    public List<Review> getNewReview() {
        return newReview;
    }

    public void setNewReview(List<Review> newReview) {
        this.newReview = newReview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", preorder=" + preorder +
                ", newReview=" + newReview +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", points=" + points +
                ", ban=" + ban +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && points == user.points && ban == user.ban && Objects.equals(preorder, user.preorder) && Objects.equals(newReview, user.newReview) && Objects.equals(name, user.name) && Objects.equals(login, user.login) && Objects.equals(pass, user.pass) && Objects.equals(email, user.email) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, preorder, newReview, name, login, pass, email, role, points, ban);
    }


}
