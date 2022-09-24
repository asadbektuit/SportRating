package com.example.sportrating.dto;

import com.example.sportrating.enums.MedalTypes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AchievementDto {
    private Integer id;
    private MedalTypes medalTypes;
}
