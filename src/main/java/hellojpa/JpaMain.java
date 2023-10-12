package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

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

/*            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeamId(team.getId());
            em.persist(member);

            //조회 식별자로 다시 조회, 객체 지향적인 방법이 아니다!
            Member findMember = em.find(Member.class, member.getId());
            Long findMemberTeamId = findMember.getTeamId();
            //연관관계가 없음
            Team findTeam = em.find(Team.class, findMemberTeamId);*/

/*            //변경 후 저장
            Team team = new Team();
            team.setName("NewTeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("newMemberA");
            //바로 참조값 team 사용 그러면 JPA에서 알아서 외래키 찾아서 저장해준다.
            member.setTeam(team);
            em.persist(member);

            //만약에 조회 쿼리를 보고 싶다면???
            em.flush(); //쿼리 다 날려버리고
            em.clear(); // 영속성 컨텍스트 다 지우면 된다. 1차 캐시가 비워져서 쿼리를 날려 조회할테니까

            // 변경 후 조회
            Member findMember = em.find(Member.class, member.getId());

            //양방향 매핑 후!
            List<Member> findMemberTeam = findMember.getTeam().getMembers();
            for (Member m : findMemberTeam) {
                System.out.println("m = " + m.getUsername());
            }
            */


/*            //양방향 매핑시 가장 많이 하는 실수 - 연관관계의 주인에 값을 입력하지 않음
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("Member1");
            em.persist(member);
*//*

            // 역방향 (주인이 아닌 방향)에 연관관계 설정을 해버렸다.
            // 역방향 매핑 [가짜 매핑]은 읽기 전용이기에 값이 들어가지지 않는다.
            team.getMembers().add(member);
            // 연관관계의 주인에 값 설정할 것!
            member.setTeam(team);
            // 둘 다 쓰는게 좋은데 이를 하나로 묶어서 연관관계 편의 메서드를 생성해서 사용하는 것을 권장한다.
*//*
//            team.addMember(member);
            member.changeTeam(team);*/

/*            Member member = new Member();
            member.setUsername("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("teamA");

            System.out.println("========================");
            team.getMembers().add(member);

            em.persist(team);*/

            Movie movie = new Movie();
            movie.setDirector("director");
            movie.setActor("actor");
            movie.setName("바람과 함께 사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie = " + findMovie);


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
