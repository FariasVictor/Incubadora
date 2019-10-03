package jdbc;

import java.util.Optional;

public class Application {

    public static void main(String[] args) {
        final TeamDAO teamDAO = new TeamDAO();
       // teamDAO.findAll();
        //System.out.println(teamDAO.findAll());
//
//        teamDAO.findById(4L)
//                .ifPresent(System.out::println);
//
//        teamDAO.deleteById(4L);
//
//        teamDAO.findById(4L)
//                .ifPresentOrElse(
//                        System.out::println,
//                        () -> System.out.println("nao encontrado")
//                );



        Optional<Team> team = teamDAO.findById(1L);
//
//        if (team.isPresent()) {
//            Membros membro = new Membros("João", team.get());
//            MembrosDAO membrosDAO = new MembrosDAO();
//            membrosDAO.insert(membro);
//        }
        MembrosDAO membrosDAO= new MembrosDAO();
        for (Membros membro:membrosDAO.findAll()
             ) {
            System.out.printf("Id: %d, Nome: %s, Fk_teams_members: %d\n",membro.getId(),membro.getName(),membro.getTeam().getId());

        };

    }

}
