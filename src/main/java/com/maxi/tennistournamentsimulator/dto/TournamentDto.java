package com.maxi.tennistournamentsimulator.dto;

import com.maxi.tennistournamentsimulator.enums.Gender;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TournamentDto {
    private Long id;
    private String name;
    private Gender gender;
    private List<PlayerDto> players;
}
