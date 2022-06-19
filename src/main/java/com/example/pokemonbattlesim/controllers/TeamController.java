package com.example.pokemonbattlesim.controllers;

import com.example.pokemonbattlesim.models.Team;
import com.example.pokemonbattlesim.service.TeamMemberService;
import com.example.pokemonbattlesim.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Controller
public class TeamController {

    private final TeamService teamService;
    private final TeamMemberService teamMemberService;
    @Autowired
    public TeamController(TeamService teamService, TeamMemberService teamMemberService) {
        this.teamService = teamService;
        this.teamMemberService = teamMemberService;
    }


    @GetMapping("/team")
    public String getTeams(Model model) {
        model.addAttribute("index", teamService.getTeams());
        System.out.println(teamService.getTeams().get(1).getName());
        System.out.println(teamService.getTeamByUserId(1L).get(0).getName());
        return "index";
    }

    @GetMapping(path = "/team/{userId}")
    public String getTeamByUserId(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("index", teamService.getTeamByUserId(userId));
        System.out.println(teamService.getTeamByUserId(userId).get(0).getName());
        return "index";
    }

    @GetMapping("/team/edit/{id}")
    public String editTeamForm(@PathVariable Long id, Model model) {
        model.addAttribute("team", teamService.getTeamById(id));
        return "edit_team";
    }


    @PostMapping("/team/{id}")
    public String updateTeam(@PathVariable Long id, @ModelAttribute("team") Team team, Model model) {
        Team existingTeam = teamService.getTeamById(id);
        existingTeam.setId(id);
        existingTeam.setName(team.getName());
        teamService.updateTeam(existingTeam);
        return "redirect:/team";
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
        teamService.saveTeam(team);
        return "redirect:/team";
    }


    @Transactional
    @GetMapping("/team/delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        teamMemberService.deleteTeamMembersByTeamId(id);
        teamService.deleteTeamById(id);
        return "redirect:/team/1";
    }

}
