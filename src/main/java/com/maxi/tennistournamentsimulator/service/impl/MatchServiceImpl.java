package com.maxi.tennistournamentsimulator.service.impl;

import com.maxi.tennistournamentsimulator.dto.PlayerDto;
import com.maxi.tennistournamentsimulator.entity.Player;
import com.maxi.tennistournamentsimulator.repository.MatchRepository;
import com.maxi.tennistournamentsimulator.repository.PlayerRepository;
import com.maxi.tennistournamentsimulator.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;

    public MatchServiceImpl(MatchRepository matchRepository, PlayerRepository playerRepository) {
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }

}
