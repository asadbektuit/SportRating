package com.example.sportrating.dto;

import com.example.sportrating.enums.MedalTypes;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class AchievementDto {
    private Integer id;
    private MedalTypes medalTypes;
    private UserDto user;
    private Integer userId;
    private SportTypeDto sportType;
    private Integer sportTypeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
