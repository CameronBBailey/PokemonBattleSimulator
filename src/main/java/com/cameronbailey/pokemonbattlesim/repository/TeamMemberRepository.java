package com.cameronbailey.pokemonbattlesim.repository;

import com.cameronbailey.pokemonbattlesim.models.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long>
{
    @Query("SELECT t FROM TeamMember t WHERE t.id = ?1")
    TeamMember findTeamMemberById(Long id);

    List<TeamMember> findTeamMembersByTeamId(Long id);

    void deleteTeamMembersByTeamId(Long id);


}
