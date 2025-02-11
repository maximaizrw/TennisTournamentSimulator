package com.maxi.tennistournamentsimulator.service.impl;

import com.maxi.tennistournamentsimulator.dto.PlayerDto;
import com.maxi.tennistournamentsimulator.entity.Player;
import com.maxi.tennistournamentsimulator.repository.PlayerRepository;
import com.maxi.tennistournamentsimulator.service.PlayerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional
    @Override
    public Optional<PlayerDto> addPlayer(PlayerDto playerDto) {

        if (playerRepository.existsByName(playerDto.getName())) {
            throw new IllegalArgumentException("Este jugador ya esta cargado en la base de datos");
        }

         Player player = Player.builder().
                name(playerDto.getName())
                .skillLevel(playerDto.getSkillLevel())
                .strength(playerDto.getStrength())
                .movementSpeed(playerDto.getMovementSpeed())
                .reactionTime(playerDto.getReactionTime())
                .genre(playerDto.getGenre())
                .build();

         Player savedPlayer = playerRepository.save(player);

         PlayerDto response = new PlayerDto(
                 savedPlayer.getId(),
                 savedPlayer.getName(),
                 savedPlayer.getSkillLevel(),
                 savedPlayer.getStrength(),
                 savedPlayer.getMovementSpeed(),
                 savedPlayer.getReactionTime(),
                 savedPlayer.getGenre()
         );
         return Optional.of(response);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PlayerDto> getPlayerById(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            return Optional.of(new PlayerDto(
                    player.getId(),
                    player.getName(),
                    player.getSkillLevel(),
                    player.getStrength(),
                    player.getMovementSpeed(),
                    player.getReactionTime(),
                    player.getGenre()
            ));
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public List<PlayerDto> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(player -> PlayerDto.builder()
                                .id(player.getId())
                                .name(player.getName())
                                .skillLevel(player.getSkillLevel())
                                .strength(player.getStrength())
                                .movementSpeed(player.getMovementSpeed())
                                .reactionTime(player.getReactionTime())
                                .genre(player.getGenre())
                                .build())
                .toList();
    }
}
