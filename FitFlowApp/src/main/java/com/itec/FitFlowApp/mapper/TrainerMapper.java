package com.itec.FitFlowApp.mapper;

import com.itec.FitFlowApp.dto.request.TrainerRequestDto;
import com.itec.FitFlowApp.dto.response.TrainerResponseDto;
import com.itec.FitFlowApp.model.entity.Trainer;
import com.itec.FitFlowApp.util.Mapper;
import org.springframework.stereotype.Component;

@Component
public class TrainerMapper implements Mapper<Trainer, TrainerResponseDto, TrainerRequestDto> {
    @Override
    public TrainerResponseDto entityToDto(Trainer trainer) {
        TrainerResponseDto trainerResponseDto = new TrainerResponseDto();
        trainerResponseDto.setId(trainer.getId());
        trainerResponseDto.setName(trainer.getName());
        trainerResponseDto.setSurname(trainer.getSurname());
        trainerResponseDto.setDni(trainer.getDni());
        trainerResponseDto.setPhone(trainer.getPhone());
        trainerResponseDto.setAddress(trainer.getAddress());
        trainerResponseDto.setEmail(trainer.getEmail());
        trainerResponseDto.setActive(trainer.isActive());
        trainerResponseDto.setProfession(trainer.getProfession());
        trainerResponseDto.setAvailable(trainer.isAvailable());
        trainerResponseDto.setRoutineList(trainer.getRoutineList());
        trainerResponseDto.setClients(trainer.getClients());
        trainerResponseDto.setGym(trainer.getGym());

        return trainerResponseDto;

    }

    @Override
    public Trainer dtoToEntity(TrainerRequestDto dtoRequest) {
        Trainer trainer = new Trainer();
        trainer.setId(dtoRequest.getId());
        trainer.setName(dtoRequest.getName());
        trainer.setSurname(dtoRequest.getSurname());
        trainer.setDni(dtoRequest.getDni());
        trainer.setPhone(dtoRequest.getPhone());
        trainer.setAddress(dtoRequest.getAddress());
        trainer.setEmail(dtoRequest.getEmail());
        trainer.setActive(dtoRequest.isActive());
        trainer.setProfession(dtoRequest.getProfession());
        trainer.setAvailable(dtoRequest.isAvailable());
        trainer.setRoutineList(dtoRequest.getRoutineList());
        trainer.setClients(dtoRequest.getClients());
        trainer.setGym(dtoRequest.getGym());

        return trainer;
    }
}
