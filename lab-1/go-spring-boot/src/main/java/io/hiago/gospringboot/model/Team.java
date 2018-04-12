package io.hiago.gospringboot.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teamId")
    private Set<Player> players;

    public Team() {
    }

    public Team(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Team(String name, String location, Set<Player> players) {
        this.name = name;
        this.location = location;
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
