package com.invillia.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {


        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("incubaria");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

//        INSERT
        //com.invillia.jpa.Team team = new com.invillia.jpa.Team("Toca do Lobo");
        TeamDAO teamDAO = new TeamDAO(entityManager);
//
        //teamDAO.insert(team);


//        UPDATE
//            com.invillia.jpa.TeamDAO teamDAO = new com.invillia.jpa.TeamDAO(entityManager);
//            com.invillia.jpa.Team team =teamDAO.findById(5L);
//            team.setName("Normandia");
//            teamDAO.update(team);
//
//        DELETE
        //  teamDAO.deleteFromId(5L);
//        SELECT
       // com.invillia.jpa.TeamDAO teamDAO = new com.invillia.jpa.TeamDAO(entityManager);
        //System.out.println(teamDAO.findById(1L));
        System.out.println(teamDAO.findAll());
// ---------------------------------------------------------------------------------------------------------------------

        MemberDAO memberDAO = new MemberDAO(entityManager);
//        com.invillia.jpa.Team team = teamDAO.findById(1L);
//        com.invillia.jpa.Member member = new com.invillia.jpa.Member("Víctor",team);
//        memberDAO.insert(member);
//
////        memberDAO.deleteById(6L);
//
        System.out.println(memberDAO.findAll());
        //System.out.println(memberDAO.findById(1L));
    }
}
