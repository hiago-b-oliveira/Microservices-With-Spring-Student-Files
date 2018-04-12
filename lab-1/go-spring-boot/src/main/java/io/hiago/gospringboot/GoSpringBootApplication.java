package io.hiago.gospringboot;

import io.hiago.gospringboot.dao.TeamRepository;
import io.hiago.gospringboot.model.Player;
import io.hiago.gospringboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class GoSpringBootApplication {


    @Autowired
    private TeamRepository teamRepository;

    public static void main(String[] args) {
        SpringApplication.run(GoSpringBootApplication.class, args);
    }


    @PostConstruct()
    public void init() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Team01", "Location01", createPlayers()));
        teams.add(new Team("Team02", "Location03"));

        teamRepository.save(teams);
    }

    private Set<Player> createPlayers() {
        Set<Player> players = new HashSet<>();
        players.add(new Player("João", "Guard"));
        players.add(new Player("José", "Quarter"));

        return players;
    }

}
