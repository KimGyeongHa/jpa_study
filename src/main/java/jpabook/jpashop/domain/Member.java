package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
<<<<<<< HEAD
=======
    private String name;

    @Embedded
    private EmbeddClass embeddClass;
>>>>>>> 4e7a4fbdb5456af5b83dc1415a0a6e40deb5535c

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public void AddOrderList(Order order){
        orders.add(order);
        order.setMember(this);
    }

    @OneToOne
    @JoinColumn(name = "LOKER_ID")
    private Locker locker;

    public Member(){}

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
<<<<<<< HEAD
=======

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


>>>>>>> 4e7a4fbdb5456af5b83dc1415a0a6e40deb5535c
}
