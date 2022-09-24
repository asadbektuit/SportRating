package com.example.sportrating.controller;

import com.example.sportrating.dto.SchoolDto;
import com.example.sportrating.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        SchoolDto result = schoolService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SchoolDto dto) {
        SchoolDto result = schoolService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid SchoolDto dto) {
        boolean result = schoolService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = schoolService.delete(id);
        return ResponseEntity.ok(result);
    }
}
