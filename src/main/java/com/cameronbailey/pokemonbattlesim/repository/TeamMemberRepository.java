package com.cameronbailey.pokemonbattlesim.repository;

import com.cameronbailey.pokemonbattlesim.models.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long>
{
    List<TeamMember> findTeamMembersByTeamId(Long id);

    void deleteTeamMembersByTeamId(Long id);
}
