package com.example.sportrating.repository;

import com.example.sportrating.entity.SportType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SportTypeRepository extends JpaRepository<SportType,Integer> {
    Optional<SportType> findByIdAndDeletedAtIsNull(Integer id);
}
