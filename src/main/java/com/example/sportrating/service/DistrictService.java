package com.example.sportrating.service;

import com.example.sportrating.dto.DistrictDto;
import com.example.sportrating.entity.District;
import com.example.sportrating.exception.BadRequest;
import com.example.sportrating.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public DistrictDto get(Integer id) {
        District district = getEntity(id);
        DistrictDto dto = new DistrictDto();
        dto.setName(district.getName());
        dto.setRegion(district.getRegion());
        dto.setRegionId(district.getRegionId());
        return dto;
    }

    private District getEntity(Integer id) {
        Optional<District> optional = districtRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("District not found");
        }
        return optional.get();
    }

    public DistrictDto create(DistrictDto dto) {
        District district = new District();
        district.setName(dto.getName());
        district.setRegion(dto.getRegion());
        district.setRegionId(dto.getRegionId());
        district.setCreatedAt(LocalDateTime.now());
        districtRepository.save(district);
        return dto;
    }

    public boolean update(Integer id, DistrictDto dto) {
        District district = getEntity(id);
        district.setName(dto.getName());
        district.setRegion(dto.getRegion());
        district.setRegionId(dto.getRegionId());
        district.setUpdatedAt(LocalDateTime.now());
        districtRepository.save(district);
        return true;
    }

    public boolean delete(Integer id) {
        District district = getEntity(id);
        district.setDeletedAt(LocalDateTime.now());
        districtRepository.save(district);
        return true;
    }
}
