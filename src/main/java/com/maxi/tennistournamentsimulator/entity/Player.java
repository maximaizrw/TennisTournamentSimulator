package com.maxi.tennistournamentsimulator.entity;

import com.maxi.tennistournamentsimulator.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Representa un jugador en el sistema de simulación de torneos de tenis.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player {

    public static final int MIN_SKILL = 0;
    public static final int MAX_SKILL = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @Min(MIN_SKILL)
    @Max(MAX_SKILL)
    private int skillLevel;

    @Min(MIN_SKILL)
    @Max(MAX_SKILL)
    private int strength;

    @Min(MIN_SKILL)
    @Max(MAX_SKILL)
    private int movementSpeed;

    @Min(MIN_SKILL)
    @Max(MAX_SKILL)
    private int reactionTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    public boolean isMale() {
        return this.gender == Gender.MALE;
    }
}