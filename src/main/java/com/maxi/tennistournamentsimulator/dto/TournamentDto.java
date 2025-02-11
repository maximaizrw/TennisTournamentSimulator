package com.maxi.tennistournamentsimulator.dto;

import com.maxi.tennistournamentsimulator.enums.Genre;
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
    private Genre genre;
    private List<PlayerDto> players;
}
