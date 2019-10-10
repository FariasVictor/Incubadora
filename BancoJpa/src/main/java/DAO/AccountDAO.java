package DAO;

import domain.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public Account findById(long id){
        return entityManager.find(Account.class,id);
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
