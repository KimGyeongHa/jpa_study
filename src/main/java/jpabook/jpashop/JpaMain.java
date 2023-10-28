package jpabook.jpashop;

import jpabook.jpashop.domain.*;

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
            mv.setMovie_name("정봉찬일대기");
            mv.setMovie_price(10000);
            mv.setPrice(100000);
            em.persist(mv);

            em.flush();
            em.clear();

            Movie find_nm = em.find(Movie.class,mv.getId());
            System.out.println("find : " + find_nm.getMovie_price());

            tx.commit();
        }catch(Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }



    }

