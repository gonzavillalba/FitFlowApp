package com.itec.FitFlowApp.dto.request;

import com.itec.FitFlowApp.model.entity.Exercise;
import com.itec.FitFlowApp.model.entity.Routine;
import com.itec.FitFlowApp.model.entity.TrainingDiary;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;
@Data
public class SessionRequestDto {
    private Long id;
    private String trainingDay;
    private String muscleGroup;
    private int sets;
    private int reps;
    private LocalTime restTime;
    private LocalTime duration;
    private boolean completed;
    private Exercise exercise;
    private Routine routine;
    private TrainingDiary trainingDiary;
}
