package jpabook.jpashop;

import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Member member = new Member();
            member.setName("김경하");

            em.persist(member);

            Order order = new Order();
            order.setMember(member);

            Delivery delivery = new Delivery();
            delivery.setName("주문1");
            delivery.setAddress(new Address("경기도","시흥시","886-22"));

            Set<String> collectVal = new HashSet<>();
            collectVal.add("감자");
            collectVal.add("고구마");
            delivery.setCollection(collectVal);

            List<String> list = new ArrayList<>();
            list.add("테스트1");
            list.add("테스트2");
            list.add("테스트3");
            delivery.setList(list);

            em.persist(delivery);

            order.setDelivery(delivery);

            em.persist(order);

            em.flush();
            em.clear();

            Order findOrder = em.find(Order.class,order.getId());
            List<String> list1 = findOrder.getDelivery().getList();

            list1.remove(0);
            list1.add(0,"테스트삭제후등록");


            //findOrder.getDelivery().setAddress(new Address("서울","중랑","555"));



            em.flush();




            tx.commit();
        }catch(Exception e) {
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }



    }

