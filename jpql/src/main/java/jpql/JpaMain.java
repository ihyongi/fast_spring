package jpql;

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
        Member member = new Member();
        member.setUsername("member1");
        member.setAge(10);
        em.persist(member);

        em.flush();
        em.clear();

        List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
                .setFirstResult(0) //0번째부터
                .setMaxResults(10) //10개 가져온다
                .getResultList();
        System.out.println("result.size() = " + result.size());
        for (Member member1 : result) {
            System.out.println("member1 = " + member1);
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
