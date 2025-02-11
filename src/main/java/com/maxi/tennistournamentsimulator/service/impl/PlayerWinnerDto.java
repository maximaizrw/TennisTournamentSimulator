package com.maxi.tennistournamentsimulator.service.impl;

import com.maxi.tennistournamentsimulator.dto.PlayerDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PlayerWinnerDto extends PlayerDto {
    public PlayerWinnerDto(Long id, @NotNull @Size(min = 2, max = 50) String name, double scoreP1) {
    }
}
