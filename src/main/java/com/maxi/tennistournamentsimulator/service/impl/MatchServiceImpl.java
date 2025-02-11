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
    private final PlayerRepository playerRepository;

    public MatchServiceImpl(MatchRepository matchRepository, PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerDto simulateMatch(long IdPlayer1, long IdPlayer2) {
        Optional<Player> player1 = playerRepository.findById(IdPlayer1);
        Optional<Player> player2 = playerRepository.findById(IdPlayer2);

        if (player1.isPresent() && player2.isPresent()) {
            Player p1 = player1.get();
            Player p2 = player2.get();

            // Calcular el impacto de la suerte (aleatorio entre 0 y 1)
            double luckFactorP1 = Math.random();  // Suerte entre 0 y 1
            double luckFactorP2 = Math.random();

            // Sumar habilidad y suerte (puedes ajustar la fórmula si lo deseas)
            double scoreP1 = p1.getSkillLevel() + luckFactorP1 * 10;  // 10 es el impacto de la suerte
            double scoreP2 = p2.getSkillLevel() + luckFactorP2 * 10;

            // Dependiendo del género, se incluyen otros factores
            if (p1.isMale()) {
                // Para masculino, considerar fuerza y velocidad de desplazamiento
                scoreP1 += p1.getStrength() * 0.5 + p1.getMovementSpeed() * 0.5;
            } else {
                // Para femenino, considerar tiempo de reacción
                scoreP1 += p1.getReactionTime() * 0.5;
            }

            if (p2.isMale()) {
                // Para masculino, considerar fuerza y velocidad de desplazamiento
                scoreP2 += p2.getStrength() * 0.5 + p2.getMovementSpeed() * 0.5;
            } else {
                // Para femenino, considerar tiempo de reacción
                scoreP2 += p2.getReactionTime() * 0.5;
            }

            // Determinar el ganador
            if (scoreP1 > scoreP2) {
                // Jugador 1 gana
                return new PlayerWinnerDto(p1.getId(), p1.getName(), scoreP1);
            } else {
                // Jugador 2 gana
                return new PlayerWinnerDto(p2.getId(), p2.getName(), scoreP2);
            }
        } else {
            // En caso de que algún jugador no se encuentre
            throw new IllegalArgumentException("Uno o ambos jugadores no existen");
        }
    }


}
