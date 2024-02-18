package jpabook.jpashop.domain;

import javax.persistence.*;
<<<<<<< HEAD
=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
>>>>>>> 4e7a4fbdb5456af5b83dc1415a0a6e40deb5535c


@Entity
public class Locker {
<<<<<<< HEAD
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
=======
    @Id@GeneratedValue
    private Long id;
    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;
>>>>>>> 4e7a4fbdb5456af5b83dc1415a0a6e40deb5535c
}
