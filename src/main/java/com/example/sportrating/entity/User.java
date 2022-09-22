package com.example.sportrating.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter

@Entity
@Table(name = ("users"))
public class User {
}
