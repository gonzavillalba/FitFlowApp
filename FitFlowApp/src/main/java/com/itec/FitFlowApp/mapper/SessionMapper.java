package com.itec.FitFlowApp.mapper;

import com.itec.FitFlowApp.dto.request.SessionRequestDto;
import com.itec.FitFlowApp.dto.response.SessionResponseDto;
import com.itec.FitFlowApp.model.entity.Session;
import com.itec.FitFlowApp.util.Mapper;
import org.springframework.stereotype.Component;

@Component
public class SessionMapper implements Mapper<Session, SessionResponseDto, SessionRequestDto> {
    @Override
    public SessionResponseDto entityToDto(Session session) {
        SessionResponseDto sessionResponseDto = new SessionResponseDto();

        sessionResponseDto.setId(session.getId());
        sessionResponseDto.setTrainingDay(session.getTrainingDay());
        sessionResponseDto.setMuscleGroup(session.getMuscleGroup());
        sessionResponseDto.setSets(session.getSets());
        sessionResponseDto.setReps(session.getReps());
        sessionResponseDto.setRestTime(session.getRestTime());
        sessionResponseDto.setDuration(session.getDuration());
        sessionResponseDto.setCompleted(session.isCompleted());
        sessionResponseDto.setExercise(session.getExercise());
        sessionResponseDto.setRoutine(session.getRoutine());
        sessionResponseDto.setTrainingDiary(session.getTrainingDiary());

        return sessionResponseDto;
    }

    @Override
    public Session dtoToEntity(SessionRequestDto dtoRequest) {
        Session session = new Session();

        session.setId(dtoRequest.getId());
        session.setTrainingDay(dtoRequest.getTrainingDay());
        session.setMuscleGroup(dtoRequest.getMuscleGroup());
        session.setSets(dtoRequest.getSets());
        session.setReps(dtoRequest.getReps());
        session.setRestTime(dtoRequest.getRestTime());
        session.setDuration(dtoRequest.getDuration());
        session.setCompleted(dtoRequest.isCompleted());
        session.setExercise(dtoRequest.getExercise());
        session.setRoutine(dtoRequest.getRoutine());
        session.setTrainingDiary(dtoRequest.getTrainingDiary());

        return session;
    }
}
