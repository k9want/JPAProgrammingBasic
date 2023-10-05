package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
/*
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            em.persist(member);

            Member findMember = em.find(Member.class, 1L);

            em.remove(findMember);

            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");
            */

/*
            //비영속
            Member member = new Member();
            member.setId(2L);
            member.setName("BasicJPA");

            //영속
            System.out.println("====== BEFORE ======");
            em.persist(member); //(1) 1차 캐시에 저장
            System.out.println("====== AFTER ======");

            Member findMember = em.find(Member.class, 2L); //(2) 따라서 영속성 컨텍스트 내에 1차 캐시에 저장된 걸 조회

            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
*/

/*
            // (1) 위에 코드와 무관 새로 실행했다는 가정하에 1차 캐시에 없어서 쿼리를 날려서 DB에서 조회 영속성 컨텍스트[1차 캐시]에 저장 후 반환
            Member findMember1 = em.find(Member.class, 2L);
            // (2) 영속성 컨텍스트[1차 캐시]에서 바로 반환
            Member findMember2 = em.find(Member.class, 2L);

            // 영속 엔티티의 동일성 보장
            System.out.println("result = " + (findMember2 == findMember1));
*/

/*
            //엔티티 등록 - 트랜잭션을 지원하는 쓰기 지원 [쓰기 지연 SQL 저장소]
            Member member1 = new Member(3L, "Member3");
            Member member2 = new Member(4L, "Member4");

            em.persist(member1);
            em.persist(member2);
            // 커밋하는 순간 쿼리들을 flush
            System.out.println("=========== before commit =========");
*/


/*            Member member = em.find(Member.class, 3L);
            member.setName("UpdateMember");
*/
/*
            Member member = new Member(200L, "Member200");
            em.persist(member);

            em.flush();

            System.out.println("===========");
*/
//            Member member = em.find(Member.class, 1L);
//            em.detach(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("catch??");
        } finally {
            em.close();
        }
        emf.close();

    }
}
