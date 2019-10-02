package jdbc;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MembrosDAO {
    private DataSource dataSource;

    public MembrosDAO(){
        PGSimpleDataSource pgSimpleDataSource= new PGSimpleDataSource();
        pgSimpleDataSource.setUser("postgres");
        pgSimpleDataSource.setPassword("postgres");
        pgSimpleDataSource.setDatabaseName("incubadora_teams");
        dataSource=pgSimpleDataSource;

//        System.out.println(pgSimpleDataSource);
    }

    public void insert(Membros membros){
        String sql="insert into membros(name, fk_times_membros) values (?,?);";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement prepareStatement= connection.prepareStatement(sql)
                ){
            prepareStatement.setString(1,membros.getName());
            prepareStatement.setLong(2,membros.getTeam().getId());
            prepareStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println("Deu ruim");
            throw new RuntimeException(e);
        }
    }

}
