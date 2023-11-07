package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

    @Embedded
    private EmbeddClass embeddClass;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public void AddOrderList(Order order){
        orders.add(order);
        order.setMember(this);
    }

    @OneToOne
    @JoinColumn(name = "LOKER_ID")
    private Locker locker;

    public Member(){}

    public Member(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
