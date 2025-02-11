package com.maxi.tennistournamentsimulator.controller;

import com.maxi.tennistournamentsimulator.dto.TournamentDto;
import com.maxi.tennistournamentsimulator.service.TournamentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tournaments")
public class TournamentController {
    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public ResponseEntity<List<TournamentDto>> getAllTournaments() {
        return ResponseEntity.ok(tournamentService.getAllTournaments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TournamentDto> getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TournamentDto> createTournament(@RequestBody TournamentDto tournamentDto) {
        Optional<TournamentDto> createdTournament = tournamentService.addTournament(tournamentDto);
        return createdTournament
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping("/{id}/players")
    public ResponseEntity<Void> addPlayersToTournament(
            @PathVariable Long id, @RequestBody List<Long> playerIds) {
        tournamentService.addPlayersToTournament(id, playerIds);
        return ResponseEntity.ok().build();
    }
}
