package com.invillia.Teams.controller;

import com.invillia.Teams.domain.Member;
import com.invillia.Teams.repository.MemberRepository;
import com.invillia.Teams.service.MemberService;
import com.invillia.Teams.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @PostMapping("/addmember")
    public String addMember(@Valid Member member, BindingResult bindingResult, Model model) {
        return memberService.insert(member, bindingResult, model);
    }

    @GetMapping("/member/{id}")
    public String findByTeam(Model model, @PathVariable("id")long id){
        model.addAttribute("members", memberService.findByTeamId(id));
        return "member";
    }

}
