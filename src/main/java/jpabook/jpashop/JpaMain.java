package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
           Movie mv = new Movie();
           mv.setActor("정봉찬");
           mv.setDirector("정봉찬");
           mv.setPrice(100000);
           mv.setStockQuantity(100);

           em.persist(mv);

           em.flush();
           em.clear();
           Movie find_mv = em.find(Movie.class,mv.getId());
           System.out.println(find_mv);


            tx.commit();
        }catch(Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }



    }

