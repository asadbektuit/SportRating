package com.example.sportrating.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

public class UserDto {
    private Integer id;
    private String phone;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birth;
    private String adress;
    private SchoolDto school;
    private Integer schoolId;
    private DistrictDto district;
    private Integer districtId;
    private RegionDto region;
    private Integer regionId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
