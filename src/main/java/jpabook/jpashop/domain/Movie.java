package jpabook.jpashop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item{
    private String movie_name;
    private int movie_price;

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getMovie_price() {
        return movie_price;
    }

    public void setMovie_price(int movie_price) {
        this.movie_price = movie_price;
    }
}
