package jpabook.jpashop.domain;

<<<<<<< HEAD
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

=======
import javax.persistence.Entity;

@Entity
public class Book extends Item{
    private String author;
    private String isbn;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
>>>>>>> 4e7a4fbdb5456af5b83dc1415a0a6e40deb5535c
}
