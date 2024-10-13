package com.itec.FitFlowApp.util;

import com.itec.FitFlowApp.model.entity.Gym;
import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String dni;
    private String phone;
    private String address;
    private String email;
    private boolean active;





}
