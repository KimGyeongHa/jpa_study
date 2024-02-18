package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Locker {
    @Id @Column(name = "LOCKER_ID")
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "locker")
    private Member member;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
