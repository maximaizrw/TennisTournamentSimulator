package com.maxi.tennistournamentsimulator.repository;

import com.maxi.tennistournamentsimulator.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    boolean existsByName(String name);
}
