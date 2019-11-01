package com.invillia.Teams.controller;

import com.invillia.Teams.domain.Team;
import com.invillia.Teams.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("teams", teamService.findAll());
        return "index";
    }

    @PostMapping("/add-team")
    public String addTeam(Model model, @Valid Team team) {
        if (!team.getName().isBlank() && !team.getName().isEmpty())
            teamService.insert(team);
        else
            System.out.println("Deu ruim");
//            throw new InvalidNameException();

        model.addAttribute("teams", teamService.findAll());
        return "index";
    }

    @GetMapping("/edit-team/{id}")
    public String editTeam(Model model, @PathVariable("id") long id) {
        System.out.println(teamService.findById(id));
        model.addAttribute("team", teamService.findById(id).get());
        return "edit-team";
    }

    @GetMapping("/delete-team/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        teamService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String update(Team team, Model model) {
        if (!team.getName().isBlank() && !team.getName().isEmpty()) {
            teamService.update(team);
        } else {
            System.out.println("Deu ruim");
        }
        model.addAttribute("teams", teamService.findAll());
        return "redirect:/";
    }

}
