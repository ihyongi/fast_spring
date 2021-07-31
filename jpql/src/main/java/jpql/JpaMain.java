package jpql;

import org.h2.value.ValueStringIgnoreCase;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        //1.psvm
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //5.code --jpa에서는 트랜잭션이 중요하다
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //트랜잭션 시작

        try {
            Team teamA=new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB=new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA); //연관관계 메서드 필요
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA); //연관관계 메서드 필요
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB); //연관관계 메서드 필요
            em.persist(member3);

            em.flush();
            em.clear();

            String query = "select m from Member m join fetch m.team"; //컬렉션의 크기를 돌려줌
            List<Member> members = em.createQuery(query, Member.class)
                    .getResultList();
            for (Member member : members) {
                System.out.println("member = " + member);
            }

            tx.commit(); //뜨악 이게없어서 쿼리문이 안나가고 있던거!!!!!!!!!**
    }catch(Exception e){
        tx.rollback();
        e.printStackTrace();
    }finally{
        em.close(); //2.매니저 종료
    }
        emf.close(); //3.팩토리 종료
}

}
