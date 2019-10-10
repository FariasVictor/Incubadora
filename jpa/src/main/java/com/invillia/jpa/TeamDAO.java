package com.invillia.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class TeamDAO {
    private final EntityManager entityManager;


    public TeamDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(final Team team){
        final EntityTransaction transaction= entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(team);
        transaction.commit();
    }
    public List<Team> findAll(){
        final TypedQuery<Team> team=entityManager.createQuery(
                "from com.invillia.jpa.Team",
                Team.class);
        return team.getResultList();
    }

    public Team findById(Long id){
        return entityManager.find(Team.class,id);
    }

    public void update(final Team team){
        final EntityTransaction transaction= entityManager.getTransaction();

        transaction.begin();
        entityManager.merge(team);
        transaction.commit();
    }

    public void deleteFromId(Long Id){
        final EntityTransaction transaction= entityManager.getTransaction();

        transaction.begin();
        Team team = findById(Id);
        entityManager.remove(team);
        transaction.commit();
    }
}
