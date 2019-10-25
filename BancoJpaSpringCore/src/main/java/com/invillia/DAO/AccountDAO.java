package com.invillia.DAO;

import com.invillia.domain.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountDAO {
    private EntityManager entityManager;
    EntityTransaction transaction;


    public AccountDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        transaction= entityManager.getTransaction();
    }

    public void insert(Account account) {
        EntityTransaction transaction;
        transaction = this.entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(account);
        transaction.commit();
    }

    public List<Account> findAll(){
        TypedQuery<Account> accounts= entityManager.createQuery(
                "SELECT a FROM Account a JOIN FETCH a.client",
                Account.class);

        return accounts.getResultList();
    }

    public Optional<Account> findById(long id){
        Account account = entityManager.find(Account.class,id);
        return account == null ? Optional.empty() : Optional.of(account);
    }

    public void deleteById(long id){
        transaction.begin();
        entityManager.remove(findById(id));
        transaction.commit();
    }

    public void update(Account account){
        transaction.begin();
        entityManager.merge(account);
        transaction.commit();
    }


}
