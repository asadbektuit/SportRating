package com.example.sportrating.repository;

import com.example.sportrating.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School,Integer> {
    Optional<School> findByIdAndDeletedAtIsNull(Integer id);
}
