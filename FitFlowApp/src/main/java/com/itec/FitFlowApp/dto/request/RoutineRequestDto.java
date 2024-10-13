package com.itec.FitFlowApp.dto.request;

import com.itec.FitFlowApp.model.entity.Client;
import com.itec.FitFlowApp.model.entity.Session;
import com.itec.FitFlowApp.model.entity.Trainer;
import com.itec.FitFlowApp.util.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RoutineRequestDto {
    private Long id;
    private String clientDni; // Cambiar Client completo por solo el DNI
    private String trainerDni; // Cambiar Trainer completo por solo el DNI
    private String routineCode;
    private String routineType;
    private LocalDate creationDate;
    private  LocalDate startDate;
    private boolean active;
    private List<Session> sessions;
    private Status status;

}
