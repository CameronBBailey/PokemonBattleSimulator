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
    /* Creates and instance of all our Service classes */
    private final TeamService teamService;
    private final TeamMemberService teamMemberService;

    private final AbilityService abilityService;

    private final ItemService itemService;

    private final NatureService natureService;

    private final AttackService attackService;

    private final PokemonService pokemonService;

    private final String redirectTeam = "redirect:/team";

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
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); /* Gets our Principal */
                model.addAttribute("index", teamService.getTeamByUserId(customUserDetails.getId())); /* Gets our Id from logged in user and returns a attribute with all teams with that user id */
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
        model.addAttribute("team", teamService.getTeamById(id));/* Adds a Team attribute to our model  */
        List<TeamMember> teamMember = teamMemberService.getTeamMembersByTeamId(id);
        model.addAttribute("teamMember", teamMember);/* Gets a list of team members based on the Team id in the path and adds it to the model */
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
        model.addAttribute("pokemon", pokemonService.getPokemon());/* Adds a specific Team and TeamMember based on the id, as well as a list of our abilities, items, natures, attacks, and pokemon. */
        return "edit_team_member";
    }


    @PostMapping("/team/{id}")
    public String updateTeam(@PathVariable Long id, @ModelAttribute("team") Team team, Model model) {
        Team existingTeam = teamService.getTeamById(id);
        existingTeam.setId(id);
        existingTeam.setName(team.getName());
        teamService.updateTeam(existingTeam); /* Saves a team updating the name */
        return redirectTeam;
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

        teamMemberService.updateTeamMember(existingTeamMember);/* Updates our team Member with all of the above info from our model */

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
        teamService.saveTeam(team); /* Takes our Team in the model and saves it as a new team */
        TeamMember teamMember = new TeamMember(1L, team.getId());
        TeamMember teamMember2 = new TeamMember(2L, team.getId());
        TeamMember teamMember3 = new TeamMember(3L, team.getId());
        TeamMember teamMember4 = new TeamMember(4L, team.getId());
        TeamMember teamMember5 = new TeamMember(5L, team.getId());
        TeamMember teamMember6 = new TeamMember(6L, team.getId()); /* Creates 6 new Team Members upon creation of a new team, gives these team members a position and sets the Team id to the model team */

        teamMemberService.addNewTeamMember(teamMember);
        teamMemberService.addNewTeamMember(teamMember2);
        teamMemberService.addNewTeamMember(teamMember3);
        teamMemberService.addNewTeamMember(teamMember4);
        teamMemberService.addNewTeamMember(teamMember5);
        teamMemberService.addNewTeamMember(teamMember6); /* Takes our team members and saves them */

        return redirectTeam;
    }


    @Transactional
    @GetMapping("/team/delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        teamMemberService.deleteTeamMembersByTeamId(id); /* Deletes all of our team members with our team Id */
        teamService.deleteTeamById(id); /* after removing the team members, removes the team. */
        return redirectTeam;
    }

}
