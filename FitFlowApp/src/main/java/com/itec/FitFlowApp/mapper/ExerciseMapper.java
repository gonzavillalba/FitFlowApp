package com.itec.FitFlowApp.mapper;

import com.itec.FitFlowApp.dto.request.ExerciseRequestDto;
import com.itec.FitFlowApp.dto.response.ExerciseResponseDto;
import com.itec.FitFlowApp.model.entity.Exercise;
import com.itec.FitFlowApp.util.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper implements Mapper<Exercise, ExerciseResponseDto, ExerciseRequestDto> {
    @Override
    public ExerciseResponseDto entityToDto(Exercise exercise) {
        ExerciseResponseDto exerciseResponseDto = new ExerciseResponseDto();
        exerciseResponseDto.setName(exercise.getName());
        exerciseResponseDto.setEquipment(exercise.getEquipment());
        exerciseResponseDto.setWeight(exercise.getWeight());
        exerciseResponseDto.setRestTime(exercise.getRestTime());
        exerciseResponseDto.setDuration(exercise.getDuration());
        exerciseResponseDto.setSession(exercise.getSession());
        return exerciseResponseDto;
    }

    @Override
    public Exercise dtoToEntity(ExerciseRequestDto dtoRequest) {
        Exercise exercise = new Exercise();
        exercise.setId(dtoRequest.getId());
        exercise.setName(dtoRequest.getName());
        exercise.setEquipment(dtoRequest.getEquipment());
        exercise.setWeight(dtoRequest.getWeight());
        exercise.setRestTime(dtoRequest.getRestTime());
        exercise.setDuration(dtoRequest.getDuration());
        exercise.setSession(dtoRequest.getSession());
        return exercise;
    }
}
