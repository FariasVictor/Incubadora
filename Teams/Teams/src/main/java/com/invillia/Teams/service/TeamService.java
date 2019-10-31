package com.invillia.Teams.service;

import com.invillia.Teams.domain.Team;
import com.invillia.Teams.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void insert(Team team) {

        if (!team.getName().isBlank() && !team.getName().isEmpty())
            teamRepository.save(team);
        else
//            throw new InvalidNameException();
            System.out.println("Deu ruim");
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Optional<Team> findById(long id) {
        return teamRepository.findById(id);
    }

    public Optional<Team> findByName(String name) {
        return teamRepository.findByName(name);
    }

    public void update(Team team) {
        if (!team.getName().isBlank() && !team.getName().isEmpty()) {
            teamRepository.save(team);
        } else {
            System.out.println("Deu ruim");
        }
    }

    public String deleteById(long id, Model model) {
        if (teamRepository.findById(id).isPresent()) {
            teamRepository.deleteById(id);
            model.addAttribute("teams", teamRepository.findAll());
            return "index";
        }
        return "#";
    }
}
