package com.invillia.Teams.service;

import com.invillia.Teams.domain.Member;
import com.invillia.Teams.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    private TeamService teamService;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void insert(Member member) {
        memberRepository.save(member);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Optional<Member> findById(long id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Member> findByTeamId(long id) {
        System.out.println(memberRepository.findByTeamId(id));
        return memberRepository.findByTeamId(id);
    }

    public void update(Member member) {
        if (!member.getName().isBlank() && !member.getName().isEmpty()) {
            memberRepository.save(member);
        } else {
            System.out.println("Deu ruim");
        }
    }

    public void deleteById(long id) {
        if (memberRepository.findById(id).isPresent()) {
            System.out.println("Não Deu ruim");
            memberRepository.deleteById(id);
        }else{
            System.out.println("Deu ruim");
            // throw exception
        }
    }
}
