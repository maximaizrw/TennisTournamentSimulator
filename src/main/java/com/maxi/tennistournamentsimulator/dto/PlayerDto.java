package com.maxi.tennistournamentsimulator.dto;

import com.maxi.tennistournamentsimulator.enums.Gender;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {
    private Long id;
    private String name;
    private int skillLevel;
    private int strength;
    private int movementSpeed;
    private int reactionTime;
    private Gender gender;
}
