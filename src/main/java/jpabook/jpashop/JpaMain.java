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
            Order order = new Order(OrderStatus.ORDER);

            Member member = new Member("김경하");
            member.AddOrderList(order);
            em.persist(member);

            Item item = new Item();
            item.setName("커피");
            item.setPrice(50000);
            em.persist(item);

            OrderItem orderItem = new OrderItem(item.getPrice(),2,item);
            em.persist(orderItem);

            order.addOrderItem(orderItem);
            em.persist(order);

            tx.commit();
        }catch(Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }



    }

