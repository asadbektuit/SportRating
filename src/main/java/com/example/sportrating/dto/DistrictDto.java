package com.example.sportrating.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class DistrictDto {
    private Integer id;
    private String name;
    private RegionDto region;
    private Integer regionId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
