package jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpashop.domain.Member;
import jpashop.domain.Order;
import jpashop.domain.OrderItem;

public class Ex1Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            /**
            * Order order = em.find(Order.class, 1L);
            (1) Order에서 memberId를 꺼내고
            Long memberId = order.getMemberId();

            (2) 꺼낸 memberId로 Member를 조회하고 있다. 관계형 DB에 맞춘[테이블] 설계의 문제점 - 객체 그래프 탐색이 불가능 참조가 끊기고 있다. 식별자만 가지고 있는 상태..
            Member member = em.find(Member.class, memberId);
            */

            /**
             * 원래 객체 설계라면?!
             * Member findMember = order.getMember();
             * */


/*
            Order order = new Order();
            order.addOrderItem(new OrderItem());
            */

/*
            Order order = new Order();
            em.persist(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            em.persist(orderItem);
            */


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
