package com.maxi.tennistournamentsimulator.service.impl;

import com.maxi.tennistournamentsimulator.repository.MatchRepository;
import com.maxi.tennistournamentsimulator.service.MatchService;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }
}
