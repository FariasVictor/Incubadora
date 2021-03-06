package com.invillia.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class MemberDAO {
    final private EntityManager entityManager;

    public MemberDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Member member) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(member);
        transaction.commit();
    }

//    public List<com.invillia.jpa.Member> findAll() {
//        final TypedQuery<com.invillia.jpa.Member> query = entityManager.createQuery(
//                "SELECT m FROM com.invillia.jpa.Member m JOIN FETCH m.team"
//                "FROM com.invillia.jpa.Member",
//                com.invillia.jpa.Member.class
//        );
//        return query.getResultList();
//    }
    public List<Member> findAll(){
        TypedQuery<Member> member= entityManager.createQuery(
                "SELECT m FROM com.invillia.jpa.Member m JOIN FETCH m.team",
                Member.class
        );
        return member.getResultList();
    }

    public Member findById(long id) {
        return entityManager.find(Member.class, id);
    }

    public void deleteById(long id) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Member member = findById(id);
        entityManager.remove(member);
        transaction.commit();
    }
}
