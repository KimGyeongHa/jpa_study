package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Delivery{

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;
    private String name;
    @OneToOne(mappedBy = "delivery")
    private Order order;
    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "collection_mapping",joinColumns = @JoinColumn(name = "DELIVERY_ID"))
    private Set<String> collection = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "list_mapping",joinColumns = @JoinColumn(name = "DELIVERY_ID"))
    private List<String> list = new ArrayList<>();


    public Set<String> getCollection() {
        return collection;
    }

    public void setCollection(Set<String> collection) {
        this.collection = collection;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
