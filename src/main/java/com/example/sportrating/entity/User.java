package com.example.sportrating.entity;

import com.example.sportrating.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("users"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = ("user_type"))
    private UserType userType;

    private String phone;

    private String password;

    @Column(name = ("first_name"))
    private String firstName;

    private LocalDate birth;

    private String address;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = ("school_id"), updatable = false, insertable = false)
    private School school;

    @Column(name = ("school_id"))
    private Integer schoolId;

    @ManyToOne
    @JoinColumn(name = ("district_id"), updatable = false, insertable = false)
    private District district;

    @Column(name = ("district_id"))
    private Integer districtId;

    @ManyToOne
    @JoinColumn(name = ("region_id"), updatable = false, insertable = false)
    private Region region;

    @Column(name = ("region_id"))
    private Integer regionId;
}
