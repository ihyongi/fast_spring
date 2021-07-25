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

        //typeQuery예시
//        TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
//           query.setParameter("username","member1");
//          Member result = query.getSingleResult();
//        System.out.println("result = " + result.getUsername()); //result = jpql.Member@7f1ef916

        em.flush();
        em.clear();

        //엔티티가 아닌경우 --모든생성자 필수 ,패키지 다 적어야함,,
        //em.createQuery("select m from Member m", MemberDTO.class).getResultList();
        List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class).getResultList();

        MemberDTO memberDTO = result.get(0);
        System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
        System.out.println("memberDTO.getAge() = " + memberDTO.getAge());

//        findMember.setAge(20); //이게 바뀌면 영속성컨텍스트에서 관리된다는거고 아니면 1차캐시라는거 --바뀜

        /*//리스트로 결과 출력시
        List<Member> resultList = query.getResultList();
        for (Member member1 : resultList) {
            System.out.println("member1 = " + member1);
        }

        //단일결과
        //exception이 발생하기 때문에 Spring Data JPa사용시 null이나 optional 반환하게끔 설정되어있음
        Member result = query.getSingleResult();
        System.out.println("result = " + result);*/


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
