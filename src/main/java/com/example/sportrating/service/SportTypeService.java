package com.example.sportrating.service;

import com.example.sportrating.dto.SportTypeDto;
import com.example.sportrating.entity.SportType;
import com.example.sportrating.exception.BadRequest;
import com.example.sportrating.repository.SportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SportTypeService {

    @Autowired
    private SportTypeRepository sportTypeRepository;

    public SportTypeDto get(Integer id) {
        SportType sportType = getEntity(id);
        SportTypeDto dto = new SportTypeDto();
        dto.setName(sportType.getName());
        return dto;
    }

    public SportTypeDto create(SportTypeDto dto) {
        SportType sportType = new SportType();
        sportType.setName(dto.getName());
        sportType.setCreatedAt(LocalDateTime.now());
        sportTypeRepository.save(sportType);
        return dto;
    }

    public boolean update(Integer id, SportTypeDto dto) {
        SportType sportType = getEntity(id);
        sportType.setName(dto.getName());
        sportType.setCreatedAt(LocalDateTime.now());
        sportTypeRepository.save(sportType);
        return true;
    }

    public boolean delete(Integer id) {
        SportType sportType = getEntity(id);
        sportType.setDeletedAt(LocalDateTime.now());
        sportTypeRepository.save(sportType);
        return true;
    }

    public SportType getEntity(Integer id) {
        Optional<SportType> optional = sportTypeRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("SportType not found");
        }
        return optional.get();
    }
}
