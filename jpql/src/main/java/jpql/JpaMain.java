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
            Team team=new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("teamA");
            member.setAge(10);
            member.setTeam(team); //연관관계 메서드 필요
            member.setType(MemberType.ADMIN);
            em.persist(member);

            em.flush();
            em.clear();

            String query = "select index(t.members) from Team t"; //컬렉션의 크기를 돌려줌
            List<Integer> result = em.createQuery(query, Integer.class)
                    .getResultList();
            for (Integer s : result) {
                System.out.println("s = " + s);
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
