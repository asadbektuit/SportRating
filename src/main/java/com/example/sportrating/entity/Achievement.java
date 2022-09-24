package com.example.sportrating.entity;

import com.example.sportrating.enums.MedalTypes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = ("achievements"))
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = ("medal_types"))
    private MedalTypes medalTypes;
}
