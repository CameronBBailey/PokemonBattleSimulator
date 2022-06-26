package com.cameronbailey.pokemonbattlesim.controllers;

import com.cameronbailey.pokemonbattlesim.models.*;
import com.cameronbailey.pokemonbattlesim.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

@Controller
public class TeamController {

    private final TeamService teamService;
    private final TeamMemberService teamMemberService;

    private final AbilityService abilityService;

    private final ItemService itemService;

    private final NatureService natureService;

    private final AttackService attackService;

    private final PokemonService pokemonService;


    @Autowired
    public TeamController(TeamService teamService, TeamMemberService teamMemberService, AbilityService abilityService, ItemService itemService, NatureService natureService, AttackService attackService, PokemonService pokemonService) {
        this.teamService = teamService;
        this.teamMemberService = teamMemberService;
        this.abilityService = abilityService;
        this.itemService = itemService;
        this.natureService = natureService;
        this.attackService = attackService;
        this.pokemonService = pokemonService;
    }


    @GetMapping("/team")
    public String getTeams(Model model) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                model.addAttribute("index", teamService.getTeamByUserId(customUserDetails.getId()));
//        System.out.println(teamService.getTeams().get(1).getName());
//        System.out.println(teamService.getTeamByUserId(1L).get(0).getName());
        return "index";
    }
//  Old function for getting a specific Users Teams
//    @GetMapping(path = "/team/{userId}")
//    public String getTeamByUserId(@PathVariable("userId") Long userId, Model model) {
//        model.addAttribute("index", teamService.getTeamByUserId(userId));
////        System.out.println(teamService.getTeamByUserId(userId).get(0).getName());
//        return "index";
//    }

    @GetMapping("/team/edit/{id}")
    public String editTeamForm(@PathVariable Long id, Model model) {
        model.addAttribute("team", teamService.getTeamById(id));
        List<TeamMember> teamMember = teamMemberService.getTeamMembersByTeamId(id);
        model.addAttribute("teamMember", teamMember);
        return "edit_team";
    }

    @GetMapping("/team/edit/editTeamMember/{teamId}/{id}")
    public String editTeamMemberForm(@PathVariable Long id,@PathVariable Long teamId, Model model) {
        model.addAttribute("teamMember", teamMemberService.getTeamMemberById(id));
        model.addAttribute("team", teamService.getTeamById(teamId));
        model.addAttribute("ability", abilityService.getAbility());
        model.addAttribute("item", itemService.getItem());
        model.addAttribute("nature", natureService.getNature());
        model.addAttribute("attack", attackService.getAttack());
        model.addAttribute("pokemon", pokemonService.getPokemon());
        return "edit_team_member";
    }


    @PostMapping("/team/{id}")
    public String updateTeam(@PathVariable Long id, @ModelAttribute("team") Team team, Model model) {
        Team existingTeam = teamService.getTeamById(id);
        existingTeam.setId(id);
        existingTeam.setName(team.getName());
        teamService.updateTeam(existingTeam);
        return "redirect:/team";
    }

    @PostMapping("/teamMember/{teamId}/{id}")
    public String updateTeamMember(@PathVariable Long id,@PathVariable Long teamId, @ModelAttribute("teamMember") TeamMember teamMember, Model model) {
        TeamMember existingTeamMember = teamMemberService.getTeamMemberById(id);
        existingTeamMember.setAbility(teamMember.getAbility());
        existingTeamMember.setItem(teamMember.getItem());
        existingTeamMember.setPokemon(teamMember.getPokemon());
        existingTeamMember.setNature(teamMember.getNature());
        existingTeamMember.setAttack1(teamMember.getAttack1());
        existingTeamMember.setAttack2(teamMember.getAttack2());
        existingTeamMember.setAttack3(teamMember.getAttack3());
        existingTeamMember.setAttack4(teamMember.getAttack4());
        existingTeamMember.setHpEv(teamMember.getHpEv());
        existingTeamMember.setAttackEv(teamMember.getAttackEv());
        existingTeamMember.setDefenseEv(teamMember.getDefenseEv());
        existingTeamMember.setSpAttackEv(teamMember.getSpDefenseEv());
        existingTeamMember.setSpDefenseEv(teamMember.getSpAttackEv());
        existingTeamMember.setSpeedEv(teamMember.getSpeedEv());
        existingTeamMember.setHpIv(teamMember.getHpIv());
        existingTeamMember.setAttackIv(teamMember.getAttackIv());
        existingTeamMember.setDefenseIv(teamMember.getDefenseIv());
        existingTeamMember.setSpAttackIv(teamMember.getSpDefenseIv());
        existingTeamMember.setSpDefenseIv(teamMember.getSpAttackIv());
        existingTeamMember.setSpeedIv(teamMember.getSpeedIv());

        teamMemberService.updateTeamMember(existingTeamMember);

        return "redirect:/team/edit/{teamId}";
    }

    @GetMapping("/team/new")
    public String createTeamForm(Model model) {
        // Create Team object to hold team data //
        Team team = new Team();
        model.addAttribute("team", team);

        return "create_team";
    }

    @PostMapping("/team")
    public String saveTeam(@ModelAttribute("team") Team team) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        team.setUser(customUserDetails.getId());
        teamService.saveTeam(team);
        TeamMember teamMember = new TeamMember(1L, team.getId());
        TeamMember teamMember2 = new TeamMember(2L, team.getId());
        TeamMember teamMember3 = new TeamMember(3L, team.getId());
        TeamMember teamMember4 = new TeamMember(4L, team.getId());
        TeamMember teamMember5 = new TeamMember(5L, team.getId());
        TeamMember teamMember6 = new TeamMember(6L, team.getId());

        teamMemberService.addNewTeamMember(teamMember);
        teamMemberService.addNewTeamMember(teamMember2);
        teamMemberService.addNewTeamMember(teamMember3);
        teamMemberService.addNewTeamMember(teamMember4);
        teamMemberService.addNewTeamMember(teamMember5);
        teamMemberService.addNewTeamMember(teamMember6);

        return "redirect:/team";
    }


    @Transactional
    @GetMapping("/team/delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        teamMemberService.deleteTeamMembersByTeamId(id);
        teamService.deleteTeamById(id);
        return "redirect:/team";
    }

}
