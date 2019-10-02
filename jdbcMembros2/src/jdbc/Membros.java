package jdbc;
import com.invillia.jdbc.Team;

public class Membros {
    private long id;
    private String name;
    private Team team;

    public Membros(long id, String name, Team team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }
}
