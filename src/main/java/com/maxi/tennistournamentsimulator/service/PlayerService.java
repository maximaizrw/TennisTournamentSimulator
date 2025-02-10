package com.maxi.tennistournamentsimulator.service;

import com.maxi.tennistournamentsimulator.dto.PlayerDto;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    Optional<PlayerDto> addPlayer(PlayerDto player);
    Optional<PlayerDto> getPlayerById(Long id);
    List<PlayerDto> getAllPlayers();
}
