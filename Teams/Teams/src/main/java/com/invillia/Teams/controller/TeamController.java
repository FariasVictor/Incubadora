package com.invillia.Teams.controller;

import com.invillia.Teams.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/add-team")
    public String addTeam() {
        return "add-team";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        teamService.deleteById(id, model);
        return "index";
    }


}
