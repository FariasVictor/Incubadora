package com.invillia.Teams.repository;

import com.invillia.Teams.domain.Member;
import com.invillia.Teams.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByName(String name);

    @Query
            (value="select * from member m join team t  on m.team_id=t.id",
            nativeQuery = true
    )
    List<Member> findTest();

}
