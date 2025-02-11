package com.maxi.tennistournamentsimulator.repository;

import com.maxi.tennistournamentsimulator.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByName(String name);
}
