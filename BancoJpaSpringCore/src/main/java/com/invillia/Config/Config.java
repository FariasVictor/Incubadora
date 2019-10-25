package com.invillia.Config;

import com.invillia.DAO.AccountDAO;
import com.invillia.DAO.ClientDAO;
import com.invillia.DAO.Operations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class Config {


    @Bean
    public EntityManager entityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("c6bank");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

//    @Bean
//    public AccountDAO accountDAO(EntityManager entityManager) {
//        return new AccountDAO(entityManager);
//    }

//    @Bean
//    public ClientDAO clientDAO(EntityManager entityManager) {
//        return new ClientDAO(entityManager);
//    }

//    @Bean
//    public Operations operations(EntityManager entityManager, AccountDAO accountDAO) {
//        return new Operations(entityManager,accountDAO);
//    }


}
