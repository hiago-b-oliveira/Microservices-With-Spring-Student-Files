package io.hiago.gospringboot.dao;

import io.hiago.gospringboot.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "players", rel = "player")
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
