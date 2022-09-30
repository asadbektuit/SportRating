package com.example.sportrating.service;

import com.example.sportrating.dto.UserDto;
import com.example.sportrating.entity.User;
import com.example.sportrating.exception.BadRequest;
import com.example.sportrating.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private DistrictService districtService;

    public UserDto get(Integer id) {
        User user = getEntity(id);
        UserDto dto = new UserDto();
        dto.setUserType(user.getUserType());
        dto.setPhone(user.getPhone());
        dto.setPassword(user.getPassword());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBirth(user.getBirth());
        dto.setAddress(user.getAddress());
        dto.setRegion(regionService.get(dto.getRegionId()));
        dto.setSchool(schoolService.get(dto.getSchoolId()));
        dto.setDistrict(districtService.get(dto.getDistrictId()));
        return dto;
    }

    public UserDto create(UserDto dto) {
        User user = new User();

        //TODO: check region
        regionService.getEntity(dto.getRegionId());
        user.setRegionId(dto.getRegionId());

        //TODO: check district
        districtService.getEntity(dto.getDistrictId());
        user.setDistrictId(dto.getDistrictId());

        //TODO: check school
        schoolService.getEntity(dto.getRegionId());
        user.setSchoolId(dto.getSchoolId());

        user.setUserType(dto.getUserType());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setBirth(dto.getBirth());
        user.setAddress(dto.getAddress());
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        return dto;
    }

    public boolean update(Integer id, UserDto dto) {
        User user = getEntity(id);

        //TODO: check region
        regionService.getEntity(dto.getRegionId());
        user.setRegionId(dto.getRegionId());

        //TODO: check district
        districtService.getEntity(dto.getDistrictId());
        user.setDistrictId(dto.getDistrictId());

        //TODO: check school
        schoolService.getEntity(dto.getRegionId());
        user.setSchoolId(dto.getSchoolId());

        user.setUserType(dto.getUserType());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setBirth(dto.getBirth());
        user.setAddress(dto.getAddress());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return true;
    }

    public boolean delete(Integer id) {
        User user = getEntity(id);
        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
        return true;
    }

    public User getEntity(Integer id) {
        Optional<User> optional = userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("User not found");
        }
        return optional.get();
    }
}
