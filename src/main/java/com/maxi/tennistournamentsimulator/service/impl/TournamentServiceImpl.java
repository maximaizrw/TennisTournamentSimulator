package com.maxi.tennistournamentsimulator.service.impl;

import com.maxi.tennistournamentsimulator.dto.TournamentDto;
import com.maxi.tennistournamentsimulator.entity.Tournament;
import com.maxi.tennistournamentsimulator.enums.Genre;
import com.maxi.tennistournamentsimulator.repository.TournamentRepository;
import com.maxi.tennistournamentsimulator.service.TournamentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public Optional<TournamentDto> addTournament(String name, String genre) {
        Genre tournamentGenre;
        try {
            tournamentGenre = Genre.valueOf(genre.toUpperCase()); // Convierte el string a enum
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Género inválido: " + genre);
        }

        if (tournamentRepository.existsByName(name)) {
            throw new IllegalArgumentException("El torneo con nombre " + name + " ya existe.");
        }

        Tournament tournament = new Tournament(
                null,
                name,
                tournamentGenre,
                null,
                null,
                null
        );

        tournament = tournamentRepository.save(tournament); // Guarda y obtiene el ID generado

        TournamentDto tournamentDto = new TournamentDto(
                tournament.getId(),
                tournament.getName(),
                tournament.getGenre()
        );

        return Optional.of(tournamentDto);
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
                        .build()) // Mueve esto dentro del map
                .toList();
    }


}
