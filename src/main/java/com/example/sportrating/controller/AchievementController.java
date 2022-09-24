package com.example.sportrating.controller;

import com.example.sportrating.dto.AchievementDto;
import com.example.sportrating.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/achievement")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        AchievementDto result = achievementService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AchievementDto dto) {
        AchievementDto result = achievementService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid AchievementDto dto) {
        boolean result = achievementService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = achievementService.delete(id);
        return ResponseEntity.ok(result);
    }
}
