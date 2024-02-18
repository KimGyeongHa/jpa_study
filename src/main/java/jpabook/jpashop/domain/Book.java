package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book extends Item{

    @Id @GeneratedValue
    @Column(name = "BOOK_ID")
    private Long id;
    private String artist;
    private String etc;

}
