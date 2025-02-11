package com.maxi.tennistournamentsimulator.service.impl;

import com.maxi.tennistournamentsimulator.dto.TournamentDto;
import com.maxi.tennistournamentsimulator.entity.Tournament;
import com.maxi.tennistournamentsimulator.repository.TournamentRepository;
import com.maxi.tennistournamentsimulator.service.TournamentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentServiceImpl implements TournamentService {

    private final TournamentRepository tournamentRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Transactional
    @Override
    public Optional<TournamentDto> addTournament(TournamentDto tournamentDto) {
        Tournament tournament = new Tournament(
                null,
                tournamentDto.getName(),
                tournamentDto.getGenre(),
                null,
                null,
                null
        );
        Tournament savedTournament = tournamentRepository.save(tournament);

        TournamentDto response = new TournamentDto(
                savedTournament.getId(),
                savedTournament.getName(),
                savedTournament.getGenre()
        );
        return Optional.of(response);
    }

    @Override
    public Optional<TournamentDto> getTournamentById(Long id) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(id);
        if (tournamentOptional.isPresent()) {
            Tournament tournament = tournamentOptional.get();
            return Optional.of(new TournamentDto(
                    tournament.getId(),
                    tournament.getName(),
                    tournament.getGenre()));
        } else {
            return Optional.empty();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<TournamentDto> getAllTournaments() {
        return tournamentRepository.findAll().stream()
                .map(tournament -> TournamentDto.builder()
                        .id(tournament.getId())
                        .name(tournament.getName())
                        .genre(tournament.getGenre())
                        .build())
                .toList();
    }
}
