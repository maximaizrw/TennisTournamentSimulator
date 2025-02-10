package com.maxi.tennistournamentsimulator.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Player player1;

    @ManyToOne
    private Player player2;

    @ManyToOne
    private Player winner;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    private String round; // Ejemplo: "Cuartos de final", "Semifinal", etc.
}