package com.example.sportrating.repository;

import com.example.sportrating.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AchievementRepository extends JpaRepository<Achievement,Integer> {

    Optional<Achievement> findByIdAndDeletedAtIsNull(Integer id);
}
