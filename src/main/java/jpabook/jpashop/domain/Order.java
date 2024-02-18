package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    List<OrderItem> orderItemList = new ArrayList<>();

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    public void addOrderItem(OrderItem orderitem){
        orderItemList.add(orderitem);
        orderitem.setOrder(this);
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order(){}
    public Order(OrderStatus status) {
        this.status = status;
    }


    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;

    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
