package com.maxi.tennistournamentsimulator.service.impl;

import com.maxi.tennistournamentsimulator.dto.TournamentDto;
import com.maxi.tennistournamentsimulator.entity.Tournament;
import com.maxi.tennistournamentsimulator.enums.Genre;
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

    //Se crea un torneo solo con nombre y genero
    @Transactional
    @Override
    public Optional<TournamentDto> addTournament(String name, String genre) {
        Genre tournamentGenre;
        try {
            tournamentGenre = Genre.valueOf(genre.toUpperCase()); // Convierte el string a enum
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Género inválido: " + genre);
        }

        // Verificar si ya existe un torneo con el mismo nombre
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


    @Transactional(readOnly = true)
    @Override
    public Optional<TournamentDto> getMovieById(Long id) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public List<TournamentDto> getAllMovies() {
        return List.of();
    }
}
