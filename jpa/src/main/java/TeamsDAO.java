import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class TeamsDAO {
    private final EntityManager entityManager;


    public TeamsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(final Teams teams){
        final EntityTransaction transaction= entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(teams);
        transaction.commit();
    }
    public List<Teams> findAll(){
        final TypedQuery<Teams> teams=entityManager.createQuery(
                "from Teams",
                Teams.class);
        return teams.getResultList();
    }

    public Teams findById(Long id){
        return entityManager.find(Teams.class,id);
    }

    public void update(final Teams teams){
        final EntityTransaction transaction= entityManager.getTransaction();

        transaction.begin();
        entityManager.merge(teams);
        transaction.commit();
    }

    public void deleteFromId(Long Id){
        final EntityTransaction transaction= entityManager.getTransaction();

        transaction.begin();
        Teams teams= findById(Id);
        entityManager.remove(teams);
        transaction.commit();
    }
}
