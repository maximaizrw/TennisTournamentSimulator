package com.maxi.tennistournamentsimulator.entity;

import com.maxi.tennistournamentsimulator.enums.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del torneo no puede estar vacío")
    private String name;

    @NotNull(message = "El género del torneo no puede ser nulo")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToMany
    @JoinTable(
            name = "tournament_players",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Player winner;

    @OneToMany(mappedBy = "tournament")
    private List<Match> matches;
}