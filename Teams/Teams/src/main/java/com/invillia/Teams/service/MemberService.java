package com.invillia.Teams.service;

import com.invillia.Teams.domain.Member;
import com.invillia.Teams.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService{
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public String insert(Member member, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-member";
        }
        memberRepository.save(member);
        model.addAttribute("members", memberRepository.findAll());
        return "index";
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public List<Member> findTest(){
        return memberRepository.findTest();
    }

    public Optional<Member> findById(long id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

    public void update(Member member) {
        memberRepository.save(member);
    }

    public void deleteById(long id) {
        memberRepository.deleteById(id);
    }
}
