package com.maxi.tennistournamentsimulator.repository;

import com.maxi.tennistournamentsimulator.entity.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {
}
