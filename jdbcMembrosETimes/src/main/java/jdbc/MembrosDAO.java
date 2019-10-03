package jdbc;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.Executor;

public class MembrosDAO {
    private DataSource dataSource;

    public MembrosDAO() {
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
        pgSimpleDataSource.setUser("postgres");
        pgSimpleDataSource.setPassword("postgres");
        pgSimpleDataSource.setDatabaseName("incubadora_teams");
        dataSource = pgSimpleDataSource;

//        System.out.println(pgSimpleDataSource);
    }

    public void insert(Membros membros) {
        String sql = "insert into members(name, fk_teams_members) values (?,?);";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement prepareStatement = connection.prepareStatement(sql)
        ) {
            prepareStatement.setString(1, membros.getName());
            prepareStatement.setLong(2, membros.getTeam().getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Deu ruim");
            throw new RuntimeException(e);
        }
    }

    public List<Membros> findAll() {
        try (
                final Connection connection = dataSource.getConnection();
                final Statement stmt = connection.createStatement();
                final ResultSet result = stmt.executeQuery("select id, name,fk_teams_members from members;");
        ) {
            final List<Membros> membros = new ArrayList<>();

            while (result.next()) {
                TeamDAO teamDAO = new TeamDAO();
                Optional<Team> team = teamDAO.findById(result.getLong("fk_teams_members"));

                if (team.isPresent()) {
                    final Membros membro = new Membros(
                            result.getLong("id"),
                            result.getString("name"),
                            team.get()
                    );

                    membros.add(membro);
                }

            }
            return membros;

        } catch (Exception e) {
            System.err.println("deu ruim");
            throw new RuntimeException(e);

        }


    }

}
