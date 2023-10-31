package jpabook.jpashop.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Locker {
    @Id@GeneratedValue
    private Long id;
    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;
}
