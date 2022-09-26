package com.example.sportrating.repository;

import com.example.sportrating.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District,Integer> {
    Optional<District> findByIdAndDeletedAtIsNull(Integer id);
}
