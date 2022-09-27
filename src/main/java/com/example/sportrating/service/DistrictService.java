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

    @Autowired
    private RegionService regionService;

    public DistrictDto get(Integer id) {
        District district = getEntity(id);
        DistrictDto dto = new DistrictDto();
        dto.setName(district.getName());
        dto.setRegion(regionService.get(dto.getRegionId()));
        return dto;
    }

    public DistrictDto create(DistrictDto dto) {
        District district = new District();
        //TODO: check region
        regionService.getEntity(dto.getRegionId());
        district.setRegionId(dto.getRegionId());

        district.setName(dto.getName());
        district.setCreatedAt(LocalDateTime.now());
        districtRepository.save(district);
        return dto;
    }

    public boolean update(Integer id, DistrictDto dto) {
        District district = getEntity(id);
        //:TODO check region
        regionService.getEntity(dto.getRegionId());
        district.setRegionId(dto.getRegionId());

        district.setName(dto.getName());
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

    public District getEntity(Integer id) {
        Optional<District> optional = districtRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new BadRequest("District not found");
        }
        return optional.get();
    }
}
