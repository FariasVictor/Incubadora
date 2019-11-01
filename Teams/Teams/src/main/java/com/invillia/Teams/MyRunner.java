package com.invillia.Teams;

import com.invillia.Teams.domain.Member;
import com.invillia.Teams.repository.MemberRepository;
import com.invillia.Teams.domain.Member;
import com.invillia.Teams.domain.Team;
import com.invillia.Teams.repository.MemberRepository;
import com.invillia.Teams.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyRunner implements CommandLineRunner {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public MyRunner(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        Team team=new Team("Rio");
//        teamRepository.save(team);
//
//        Member Member = new Member("Víctor", team);
//        memberRepository.save(Member);
//        memberRepository.findById(2L);
    }
}
