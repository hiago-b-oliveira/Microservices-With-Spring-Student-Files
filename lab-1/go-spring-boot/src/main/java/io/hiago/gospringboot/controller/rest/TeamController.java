package io.hiago.gospringboot.controller.rest;

import io.hiago.gospringboot.dao.TeamRepository;
import io.hiago.gospringboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/teams")
    public Iterable<Team> getTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/teams/{id}")
    public Team getTeam(@PathVariable("id") Long id) {
        return teamRepository.findOne(id);
    }
}
