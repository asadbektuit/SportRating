package com.example.sportrating.service;

import com.example.sportrating.dto.SchoolDto;
import com.example.sportrating.entity.School;
import com.example.sportrating.exception.BadRequest;
import com.example.sportrating.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public SchoolDto get(Integer id) {
        School school = getEntity(id);
        SchoolDto dto = new SchoolDto();
        dto.setName(school.getName());
        dto.setRegionId(school.getRegionId());
        dto.setDistrictId(school.getDistrictId());
        return dto;
    }

    private School getEntity(Integer id) {
        Optional<School> optional = schoolRepository.findByIdAndDeletedAtIsNull(id);
        if(optional.isEmpty()){
            throw new BadRequest("School not found");
        }
        return optional.get();
    }

    public SchoolDto create(SchoolDto dto) {
        School school = new School();
        school.setName(dto.getName());
        school.setRegionId(dto.getRegionId());
        school.setDistrictId(dto.getDistrictId());
        school.setCreatedAt(LocalDateTime.now());
        schoolRepository.save(school);
        return dto;
    }

    public boolean update(Integer id, SchoolDto dto) {
        School school = getEntity(id);
        school.setName(dto.getName());
        school.setRegionId(dto.getRegionId());
        school.setDistrictId(dto.getDistrictId());
        school.setUpdatedAt(LocalDateTime.now());
        schoolRepository.save(school);
        return true;
    }

    public boolean delete(Integer id) {
        School school = getEntity(id);
        school.setDeletedAt(LocalDateTime.now());
        schoolRepository.save(school);
        return true;
    }
}
