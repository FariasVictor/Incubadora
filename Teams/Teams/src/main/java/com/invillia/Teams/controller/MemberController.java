package com.invillia.Teams.controller;

import com.invillia.Teams.domain.Member;
import com.invillia.Teams.repository.MemberRepository;
import com.invillia.Teams.service.MemberService;
import com.invillia.Teams.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MemberController {
    private final MemberService memberService;
    private final TeamService teamService;

    @Autowired
    public MemberController(MemberService memberService, TeamService teamService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.teamService = teamService;
    }

    @PostMapping("/add-member/{idTeam}")
    public String addMember(@Valid Member member, Model model, @PathVariable("idTeam") long idTeam) {
        memberService.insert(member);
        model.addAttribute("members", memberService.findByTeamId(idTeam));
        return "member";
    }

    @GetMapping("/member/{idTeam}")
    public String findByTeam(Model model, @PathVariable("idTeam")long idTeam){
        model.addAttribute("members", memberService.findByTeamId(idTeam));
        model.addAttribute("idDoTime",idTeam);
        return "member";
    }

    @GetMapping("/delete-member/{id}/{idTeam}")
    public String deleteById(@PathVariable("id")long id,@PathVariable("idTeam") long idTeam, Model model){
        memberService.deleteById(id);
        model.addAttribute("members",memberService.findByTeamId(idTeam));
        return "member";
    }
}
