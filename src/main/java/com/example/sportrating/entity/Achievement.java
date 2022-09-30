package com.example.sportrating.entity;

import com.example.sportrating.enums.MedalTypes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("achievements"))
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = ("sport_type_id"), insertable = false, updatable = false)
    private SportType sportType;

    @Column(name = ("sport_type_id"))
    private Integer sportTypeId;

    @ManyToOne
    @JoinColumn(name = ("user_id"), insertable = false, updatable = false)
    private User user;

    @Column(name = ("user_id"))
    private Integer userId;

    @Column(name = ("medal_types"))
    private MedalTypes medalTypes;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
