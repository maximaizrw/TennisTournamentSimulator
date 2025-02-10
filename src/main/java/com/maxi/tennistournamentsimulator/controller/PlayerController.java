package com.maxi.tennistournamentsimulator.controller;

import com.maxi.tennistournamentsimulator.dto.PlayerDto;
import com.maxi.tennistournamentsimulator.entity.Player;
import com.maxi.tennistournamentsimulator.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<PlayerDto> addPlayer(@RequestBody PlayerDto player) {
        playerService.addPlayer(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }
}
