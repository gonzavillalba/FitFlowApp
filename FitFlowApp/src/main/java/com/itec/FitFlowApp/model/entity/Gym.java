package com.itec.FitFlowApp.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "gyms")
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String gymCode;
    private String name;
    private String phone;
    private String email;
    private String address;
    @OneToMany(mappedBy = "gym")
    private List<Client>clientList;
    @OneToMany(mappedBy = "gym")
    private List<Trainer>trainerList;
    @OneToMany(mappedBy = "gym")
    private List<Nutritionist>nutritionistList;

}
