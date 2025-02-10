package com.maxi.tennistournamentsimulator.repository;

import com.maxi.tennistournamentsimulator.entity.Tournament;
import org.springframework.data.repository.CrudRepository;

public interface TournamentRepository extends CrudRepository<Tournament, Long> {
    boolean existsByName(String name);
}
