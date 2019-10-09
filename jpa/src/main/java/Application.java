import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {


        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("incubaria");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

//        INSERT
        //Team team = new Team("Toca do Lobo");
        TeamDAO teamDAO = new TeamDAO(entityManager);
//
        //teamDAO.insert(team);


//        UPDATE
//            TeamDAO teamDAO = new TeamDAO(entityManager);
//            Team team =teamDAO.findById(5L);
//            team.setName("Normandia");
//            teamDAO.update(team);
//
//        DELETE
        //  teamDAO.deleteFromId(5L);
//        SELECT
       // TeamDAO teamDAO = new TeamDAO(entityManager);
        //System.out.println(teamDAO.findById(1L));
        System.out.println(teamDAO.findAll());
// ---------------------------------------------------------------------------------------------------------------------

        MemberDAO memberDAO = new MemberDAO(entityManager);
//        Team team = teamDAO.findById(1L);
//        Member member = new Member("Víctor",team);
//        memberDAO.insert(member);
//
////        memberDAO.deleteById(6L);
//
        System.out.println(memberDAO.findAll());
        //System.out.println(memberDAO.findById(1L));
    }
}
