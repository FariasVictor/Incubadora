import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {


        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("incubaria");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

//        INSERT
//        Teams teams = new Teams("Toca do Lobo");
        TeamsDAO teamsDAO = new TeamsDAO(entityManager);
//
//        teamsDAO.insert(teams);


//        UPDATE
//            TeamsDAO teamsDAO = new TeamsDAO(entityManager);
//            Teams teams =teamsDAO.findById(3L);
//            teams.setName("Normandia");
//            teamsDAO.update(teams);

//        DELETE
        teamsDAO.deleteFromId(4L);
//        SELECT
//        TeamsDAO teamsDAO = new TeamsDAO(entityManager);
        System.out.println(teamsDAO.findAll());
        //System.out.println(teamsDAO.findById(1L));
    }
}
