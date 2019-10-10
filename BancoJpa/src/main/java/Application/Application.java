package Application;
import domain.*;
import DAO.*;

import DAO.ClientDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("c6bank");
        EntityManager entityManager= entityManagerFactory.createEntityManager();

//        Client client = new Client("Víctor", "03024480129");
//
////INSERT
//        ClientDAO clientDAO=new ClientDAO(entityManager);
//
//        //clientDAO.insert(client);
//
//
////DELETE
////        Client clientToDelete= clientDAO.findById(4L);
////        clientDAO.delete(clientToDelete);
//
//        Client clientToUpdate= clientDAO.findById(2L);
//        clientToUpdate.setName("Rodrigo");
//        clientDAO.update(client);
//
//        System.out.println("Find All:"+clientDAO.findAll());

        ClientDAO clientDAO=new ClientDAO(entityManager);
        Client client = clientDAO.findById(1L);
//        Account account=new Account(client,200,500,013);
//        Account account2=new Account(client,200,500,001);
        AccountDAO accountDAO=new AccountDAO(entityManager);
//INSERT
//        accountDAO.insert(account);
//        accountDAO.insert(account2);


//SELECT
//        System.out.println(accountDAO.findById(2L));
//        System.out.println(accountDAO.findAll());

//DELETE
//        accountDAO.deleteById(3L);

//UPDATE
//        Account account=accountDAO.findById(2L);
//        account.setBalance(1000);
//        accountDAO.update(account);

        Account account= accountDAO.findById(2L);
        Operations op=new Operations(entityManager);
        op.withdraw(account,1300);
        System.out.println(accountDAO.findAll());
    }


}
