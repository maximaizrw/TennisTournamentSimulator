package com.maxi.tennistournamentsimulator.service;

import com.maxi.tennistournamentsimulator.dto.TournamentDto;

import java.util.List;
import java.util.Optional;

public interface TournamentService {
    Optional<TournamentDto> addTournament(String name, String genre);
    Optional<TournamentDto> getTournamentById(Long id);
    List<TournamentDto> getAllTournaments();
}