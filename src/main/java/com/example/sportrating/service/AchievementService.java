package com.example.sportrating.service;

import com.example.sportrating.dto.AchievementDto;
import com.example.sportrating.entity.Achievement;
import com.example.sportrating.exception.BadRequest;
import com.example.sportrating.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    public AchievementDto get(Integer id) {
        Achievement achievement = getEntity(id);
        AchievementDto dto = new AchievementDto();
        return dto;
    }

    private Achievement getEntity(Integer id) {
        Optional<Achievement> optional = achievementRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("Achievement not found");
        }
        return optional.get();
    }

    public AchievementDto create(AchievementDto dto) {
        return null;
    }

    public boolean update(Integer id, AchievementDto dto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
