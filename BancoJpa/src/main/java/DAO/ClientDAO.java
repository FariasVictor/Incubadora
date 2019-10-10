package DAO;
import domain.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClientDAO {
    private EntityManager entityManager;
    EntityTransaction transaction;

    public ClientDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        transaction= entityManager.getTransaction();
    }


    public void insert(Client client) {
        EntityTransaction transaction;
        transaction = this.entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(client);
        transaction.commit();
    }

    public List<Client> findAll(){
        TypedQuery<Client> clients= entityManager.createQuery(
                "FROM Client",
                Client.class
        );
        return clients.getResultList();
    }

    public Client findById(long id){
        return entityManager.find(Client.class,id);
    }

    public void update(Client client){

        transaction.begin();
        entityManager.merge(client);
        transaction.commit();
    }

    public void delete(Client client){
        transaction.begin();
        entityManager.remove(client);
        transaction.commit();
    }
}
