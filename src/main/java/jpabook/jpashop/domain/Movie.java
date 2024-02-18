package jpabook.jpashop.domain;
import javax.persistence.Entity;

@Entity
<<<<<<< HEAD
public class Movie extends Item{
    private String movie_name;
    private int movie_price;
=======
public class Movie extends Item {
    private String director;
    private String actor;
>>>>>>> 4e7a4fbdb5456af5b83dc1415a0a6e40deb5535c

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
