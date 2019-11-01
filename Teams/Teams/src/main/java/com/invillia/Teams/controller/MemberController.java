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

//    @PostMapping("/member")
//    public String allMembers(Model model ) {
//        model.addAttribute("members", memberService.findAll());
//        return "member";
//    }

    @PostMapping("/add-member/{teamId}")
    public String addMember(@Valid Member member, Model model, @PathVariable("teamId") long teamId) {
        memberService.insert(member);
        model.addAttribute("members", memberService.findByTeamId(teamId));
        model.addAttribute("teamId",teamId);
        return "member";
    }

    @GetMapping("/member/{teamId}")
    public String findByTeam(Model model, @PathVariable("teamId")long teamId){
        model.addAttribute("members", memberService.findByTeamId(teamId));
        model.addAttribute("teamId",teamId);
        return "member";
    }

    @GetMapping("/delete-member/{teamId}/{id}")
    public String deleteById(@PathVariable("id")long id,@PathVariable("teamId") long teamId, Model model){
        memberService.deleteById(id);
        model.addAttribute("members",memberService.findByTeamId(teamId));
        model.addAttribute("teamId",teamId);
        return "member";
    }
    @GetMapping("/edit-member/{teamId}/{id}")
    public String edit(Model model, @PathVariable("id")long id,@PathVariable("teamId") long teamId){
        model.addAttribute("member",memberService.findById(id).get());
        model.addAttribute("teamId",teamId);
        return "edit-member";
    }

    @PostMapping("update-member/{teamId}/{id}")
    public String update(Model model,Member member,@PathVariable("teamId") long teamId){
        memberService.update(member);
        model.addAttribute("members", memberService.findByTeamId(teamId));
        model.addAttribute("teamId",teamId);
        return "member";
    }

}
