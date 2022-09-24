package com.example.sportrating.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("schools"))
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = ("region_id"), insertable = false, updatable = false)
    private Region region;

    @Column(name = ("region_id"))
    private Integer regionId;

    @ManyToOne
    @JoinColumn(name = ("district_id"), insertable = false, updatable = false)
    private District district;

    @Column(name = ("district_id"))
    private Integer districtId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
