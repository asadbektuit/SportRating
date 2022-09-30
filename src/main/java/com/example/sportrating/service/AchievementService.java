package com.example.sportrating.service;

import com.example.sportrating.dto.AchievementDto;
import com.example.sportrating.entity.Achievement;
import com.example.sportrating.exception.BadRequest;
import com.example.sportrating.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private SportTypeService sportTypeService;

    @Autowired
    private UserService userService;

    public AchievementDto get(Integer id) {
        Achievement achievement = getEntity(id);
        AchievementDto dto = new AchievementDto();
        dto.setMedalTypes(achievement.getMedalTypes());
        dto.setSportType(sportTypeService.get(dto.getSportTypeId()));
        dto.setUser(userService.get(dto.getUserId()));
        return dto;
    }

    public AchievementDto create(AchievementDto dto) {
        Achievement achievement = new Achievement();
        //TODO: check sportType
        sportTypeService.getEntity(dto.getSportTypeId());
        achievement.setSportTypeId(dto.getSportTypeId());

        //TODO: check user
        userService.getEntity(dto.getUserId());
        achievement.setUserId(dto.getUserId());

        achievement.setMedalTypes(dto.getMedalTypes());
        achievement.setCreatedAt(LocalDateTime.now());
        achievementRepository.save(achievement);
        return dto;
    }

    public boolean update(Integer id, AchievementDto dto) {
        Achievement achievement = getEntity(id);
        //TODO: check sportType
        sportTypeService.getEntity(dto.getSportTypeId());
        achievement.setSportTypeId(dto.getSportTypeId());

        //TODO: check user
        userService.getEntity(dto.getUserId());
        achievement.setUserId(dto.getUserId());

        achievement.setMedalTypes(dto.getMedalTypes());
        achievement.setUpdatedAt(LocalDateTime.now());
        achievementRepository.save(achievement);
        return true;
    }

    public boolean delete(Integer id) {
        Achievement achievement = getEntity(id);
        achievement.setDeletedAt(LocalDateTime.now());
        achievementRepository.save(achievement);
        return true;
    }

    public Achievement getEntity(Integer id) {
        Optional<Achievement> optional = achievementRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("Achievement not found");
        }
        return optional.get();
    }
}
