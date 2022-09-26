package com.example.sportrating.repository;

import com.example.sportrating.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region,Integer> {
    Optional<Region> findByIdAndDeletedAtIsNull(Integer id);

}
