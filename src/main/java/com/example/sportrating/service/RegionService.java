package com.example.sportrating.service;

import com.example.sportrating.dto.RegionDto;
import com.example.sportrating.entity.Region;
import com.example.sportrating.exception.BadRequest;
import com.example.sportrating.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public RegionDto get(Integer id) {
        Region region = getEntity(id);
        RegionDto dto = new RegionDto();
        dto.setName(region.getName());
        return dto;
    }

    public RegionDto create(RegionDto dto) {
        Region region = new Region();
        region.setName(dto.getName());
        region.setCreatedAt(LocalDateTime.now());
        Region savedRegion = regionRepository.save(region);
        return RegionDto.builder().id(savedRegion.getId())
                .createdAt(savedRegion.getCreatedAt())
                .name(savedRegion.getName())
                .updatedAt(savedRegion.getUpdatedAt()).build();
    }

    public boolean update(Integer id, RegionDto dto) {
        Region region = getEntity(id);
        region.setName(dto.getName());
        region.setUpdatedAt(LocalDateTime.now());
        regionRepository.save(region);
        return true;
    }

    public boolean delete(Integer id)  {
        Region region = getEntity(id);
        region.setDeletedAt(LocalDateTime.now());
        regionRepository.save(region);
        return true;
    }

    public Region getEntity(Integer id) {
        Optional<Region> optional = regionRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("Region not found");
        }
        return optional.get();
    }
}
