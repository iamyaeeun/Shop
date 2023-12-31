package opensource.shop.repository;

import lombok.RequiredArgsConstructor;
import opensource.shop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    //회원 저장
    public void save(Member member) {
        em.persist(member);
    }

    //특정 회원 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    //모든 회원 조회
    public List<Member> findAll() {
        List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();

        return result;
    }

    //이름으로 회원 조회
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
