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

          Parent pr = new Parent();
          Child ch = new Child();
          Child ch2 = new Child();

          pr.addChild(ch);
          pr.addChild(ch2);

          em.persist(pr);

          em.flush();
          em.clear();

          Parent find = em.find(Parent.class,pr.getId());
          find.getChildList().remove(0);

          tx.commit();
        }catch(Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }



    }

