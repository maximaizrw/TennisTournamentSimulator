package com.maxi.tennistournamentsimulator.repository;

import com.maxi.tennistournamentsimulator.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
