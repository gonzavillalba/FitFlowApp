package com.itec.FitFlowApp.mapper;

import com.itec.FitFlowApp.dto.request.RoutineRequestDto;
import com.itec.FitFlowApp.dto.response.RoutineResponseDto;
import com.itec.FitFlowApp.model.entity.Routine;
import com.itec.FitFlowApp.util.Mapper;
import org.springframework.stereotype.Component;

@Component
public class RoutineMapper implements Mapper<Routine, RoutineResponseDto, RoutineRequestDto> {
    @Override
    public RoutineResponseDto entityToDto(Routine routine) {
        RoutineResponseDto routineResponseDto = new RoutineResponseDto();

        routineResponseDto.setClient(routine.getClient());
        routineResponseDto.setTrainer(routine.getTrainer());
        routineResponseDto.setRoutineCode(routine.getRoutineCode());
        routineResponseDto.setRoutineType(routine.getRoutineType());
        routineResponseDto.setCreationDate(routine.getCreationDate());
        routineResponseDto.setStartDate(routine.getStartDate());
        routineResponseDto.setActive(routine.isActive());
        routineResponseDto.setSessions(routine.getSessions());
        routineResponseDto.setStatus(routine.getStatus());

        return routineResponseDto;
    }

    @Override
    public Routine dtoToEntity(RoutineRequestDto dtoRequest) {
        Routine routine = new Routine();

        routine.setRoutineCode(dtoRequest.getRoutineCode());
        routine.setRoutineType(dtoRequest.getRoutineType());
        routine.setCreationDate(dtoRequest.getCreationDate());
        routine.setStartDate(dtoRequest.getStartDate());
        routine.setActive(dtoRequest.isActive());
        routine.setSessions(dtoRequest.getSessions());
        routine.setStatus(dtoRequest.getStatus());

        return routine;
    }
}
